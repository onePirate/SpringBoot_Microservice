package com.back.utils;

import it.sauronsoftware.jave.Encoder;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class FileInfo {

    private static String strPath = "I:\\编程学习\\05.编程栈复杂学习\\龙果学院\\深入理解Java虚拟机（jvm性能调优+内存模型+虚拟机原理）";
    private static String suffix = "avi";

    public static void main(String[] args) {
        getFileTime();
//        renameFile();
    }

    public static void renameFile(){
        List<String> list = FileInfo.getFileList(strPath, suffix);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).substring(49));
            String newName = "";
            if (i <9) {
                newName = "0"+(i+1)+"_"+list.get(i).substring(61);
            }else{
                newName = (i+1)+"_"+list.get(i).substring(61);
            }
            System.out.println(newName.split("\\\\")[0]+".avi");
            System.out.println(renameFile(strPath,list.get(i).substring(49),newName.split("\\\\")[0]+".avi"));
        }
    }

    public static void getFileTime(){
        List<String> list = FileInfo.getFileList(strPath, suffix);
        long timeSum = 0;
        for (int i = 0; i < list.size(); i++) {
            //特殊需求改造
//            timeSum = getTimeSum(list, timeSum, i);
            timeSum += FileInfo.getVideoTime(list.get(i));
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

    /** 文件重命名
     * @param path 文件路径
     * @param oldname 原有的文件名
     * @param newname 新的文件名
     */
    public static boolean renameFile(String path, String oldname, String newname) {
        // 新的文件名和以前文件名不同时,才有必要进行重命名
        if (!oldname.equals(newname)) {
            File oldfile = new File(path + "/" + oldname);
            File newfile = new File(path + "/" + newname);
            if (!oldfile.exists()) {
                log.error("需要重命名的文件不存在");
                return false;// 重命名文件不存在
            }
            if (newfile.exists()) {// 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                log.error(newname + "已经存在！");
                return false;
            } else {
                boolean isSuccess = oldfile.renameTo(newfile);
                return isSuccess;
            }
        } else {
            log.error("新文件名和旧文件名相同...");
        }
        return false;
    }


    /**
     * 获得视频文件的时长
     *
     * @param strPath
     * @return
     */
    static List filelist = new ArrayList();
    public static List<String> getFileList(String strPath, String suffix) {
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
