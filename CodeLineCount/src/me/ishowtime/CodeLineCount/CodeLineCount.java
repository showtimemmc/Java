package me.ishowtime.CodeLineCount;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 利用多线程计算源码文件的数量
 * Created by iShowTime on 15/2/7.
 */

public class CodeLineCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> fileTypes = new HashSet<>();
        System.out.print("输入要统计的源码文件类型: ");
        String line = scanner.nextLine().trim();
        //输入的类型名分别输入类型数组
        StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
            fileTypes.add(st.nextToken());
        }

        System.out.print("输入源码文件路径: ");
        String filePath = scanner.nextLine().trim();
        File file = new File(filePath);
        //文件是否存在
        if (!file.exists()) {
            System.out.println("File is not found");
            System.exit(-1);
        }
        //TODO BUGFIX 单个文件，扩展名不符合要求，则直接返回文件类型错误
        //向线程池提交任务
        ExecutorService pool = Executors.newCachedThreadPool();
        Counter counter = new Counter(new File(filePath),pool,fileTypes);
        Future<Integer> result = pool.submit(counter);
        try {
            System.out.println(result.get() + " lines");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
