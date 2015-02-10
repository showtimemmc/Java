package me.ishowtime.helper;

import java.io.File;

/**
 * 文件操作相关辅助类
 * Created by iShowTime on 15/2/8.
 */
public class FileHelper {
    /**
     * 获取文件扩展名
     * @param pathName 文件路径字符串
     * @return
     */
    public static final String getExtentionName(String pathName) {
        if (pathName == null | pathName.length() == 0) {
            return null;
        }
        File file = new File(pathName.trim());
        return getExtention(file);
    }

    /**
     * 获取文件扩展名
     * @param file  文件对象
     * @return
     */
    public static final String getExtentionName(File file) {
        if (file == null) {
            return null;
        }
        return getExtention(file);
    }

    /**
     * 获取文件扩展名
     * @param file
     * @return
     */
    private static final String getExtention(File file) {
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }



    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
 //       String pathName =  "/Users/ishowtime/Documents/src/Java/Helper/FileHelper/FileHelper.iml";
        String pathName = "FileHelper/FileHelper.iml";
        //exists函数只能判断绝对路径
        File file = new File(pathName).getAbsoluteFile();
        if (file.exists()) {
            System.out.println("exist");
        } else {
            System.out.println("not exist");
        }
    }
}
