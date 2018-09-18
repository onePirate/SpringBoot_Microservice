package com.spark.service;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: gwx556610
 * @Date: 15:26 2018/9/18
 * @Desc:
 */
@Service
public class SparkFirstService {
    private static final Pattern SPACE = Pattern.compile(" ");

    @Autowired
    private JavaSparkContext sc;

    public Map<String, Object> firstLearn() {

        Map<String, Object> result = new HashMap<>();
        JavaRDD<String> lines = sc.textFile("D:\\Program Files\\JavaDevelopTools\\IDEAWorkSpace\\Base\\spark\\src\\main\\resources\\static\\txt\\sdeegsa.txt").cache();

        lines.map(str -> {
                    System.out.println(str);
                    return str;
                });

        System.out.println("-------------------------------------------------------");
        System.out.println(lines.count());

        JavaRDD<String> words = lines
                .flatMap(str -> Arrays.asList(SPACE.split(str)).iterator());

        JavaPairRDD<String, Integer> ones = words
                .mapToPair(str -> new Tuple2<>(str, 1));

        JavaPairRDD<String, Integer> counts = ones
                .reduceByKey((Integer i1, Integer i2) -> (i1 + i2));

        JavaPairRDD<Integer, String> temp = counts
                .mapToPair(tuple -> new Tuple2<>(tuple._2, tuple._1));

        JavaPairRDD<String, Integer> sorted = temp
                .sortByKey(false)
                .mapToPair(tuple -> new Tuple2<>(tuple._2, tuple._1));

        System.out.println("-------------------------------------------------------");
        System.out.println(sorted.count());

        List<Tuple2<String, Integer>> output = sorted.collect();
        for (Tuple2<String, Integer> tuple : output) {
            result.put(tuple._1(),tuple._2());
        }

        return result;
    }
}
