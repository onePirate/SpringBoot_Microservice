package com.back.utils;

import it.sauronsoftware.jave.Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaodw
 * @createTime 2019-04-13 13:11
 * @description
 */
public class FileInfo {


    private static String strPath = "I:\\01.编程学习\\《特殊资料01》尚硅谷JavaWeb系统学习\\第 4 阶段\\24.尚硅谷Jenkins视频教程";
    private static String suffix = "avi";

    public static void main(String[] args) {
        List<String> list = FileInfo.getFileList(strPath, suffix);
        long timeSum = 0;
        for (int i = 0; i < list.size(); i++) {
            //特殊需求改造
//            timeSum = getTimeSum(list, timeSum, i);
            timeSum += getVideoTime(list.get(i));
        }
        System.out.println("===================总共的时间为：" + Double.valueOf(timeSum) / 1000 / 60 / 60);
    }

    private static long getTimeSum(List<String> list, long timeSum, int i) {
        System.err.println("============>index:" + Integer.valueOf(list.get(i).substring(65, 67)));
        Integer index = Integer.valueOf(list.get(i).substring(65, 67));
        if (index >= 48 && index < 53) {
            timeSum += getVideoTime(list.get(i));
        }
        return timeSum;
    }


    /**
     * 获得视频文件的时长
     *
     * @param strPath
     * @return
     */
    public static List<String> getFileList(String strPath, String suffix) {
        List filelist = new ArrayList();
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath(), suffix); // 获取文件绝对路径
                } else if (fileName.endsWith(suffix)) { // 判断文件名是否以.avi结尾
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println(strFileName);
                    filelist.add(strFileName);
                } else {
                    continue;
                }
            }

        }
        return filelist;
    }

    /**
     * 获得视频的基本信息
     *
     * @param path
     * @return
     */
    public static long getVideoTime(String path) {
        File source = new File(path);
        Encoder encoder = new Encoder();
        FileChannel fc = null;
        String size = "";
        try {
            it.sauronsoftware.jave.MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            System.out.println("此视频时长为:" + ls / 60000 + "分钟   或者：" + (ls) / 1000 + "秒！");
            System.out.println("此视频高度为:" + m.getVideo().getSize().getHeight());
            System.out.println("此视频宽度为:" + m.getVideo().getSize().getWidth());
            System.out.println("此视频格式为:" + m.getFormat());
            FileInputStream fis = new FileInputStream(source);
            fc = fis.getChannel();
            BigDecimal fileSize = new BigDecimal(fc.size());
            size = fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP) + "MB";
            System.out.println("此视频大小为" + size);
            return ls;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fc) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

}
