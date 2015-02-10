package me.ishowtime.CodeLineCount;

import me.ishowtime.helper.FileHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by iShowTime on 15/2/8.
 */
public class Counter implements Callable<Integer> {
    private int count = 0;
    private File directory;
    private ExecutorService pool;
    private Set<String> fileTypes;

    public Counter(File directory, ExecutorService pool,Set<String> types) {
        this.directory = directory;
        this.pool = pool;
        this.fileTypes = types;
    }

    /**
     * 计算单独文件的行数
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static final int countFile(File file) throws FileNotFoundException{
        try (Scanner in = new Scanner(file))
        {
            int lineCount = 0;
            while(in.hasNextLine()) {
                //TODO 正则表达式去掉注释的行
                String line = in.nextLine().trim();
                if (line.length() > 0) {
                    lineCount++;
                }
            }
            return lineCount;
        }
    }

    /**
     * 判断文件类型是否符合要求
     * @param file
     * @return
     */
    private  final boolean isRightType(File file) {
            String typeString = FileHelper.getExtentionName(file);
            return this.fileTypes.contains(typeString);
    }

    @Override
    public Integer call() throws Exception {
        try {
            //如果this.directory是一个文件，直接计算并返回
            if (this.directory.isFile() && isRightType(this.directory)) {
                this.count += Counter.countFile(this.directory);
                return this.count;
            }
            //目录的话则迭代每一个文件进行处理
            File[] files = this.directory.listFiles();
            List<Future<Integer>> results =new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()) {
                    Future<Integer> future = this.pool.submit(new Counter(file,this.pool,this.fileTypes));
                    results.add(future);
                } else {//file is not
                    if (isRightType(file)) {
                        this.count += Counter.countFile(file);
                    }
                }
            }
            //获取线程执行结果
            for (Future<Integer> result : results) {
                try {
                    //收集其他线程的结果集
                    this.count += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.count;
    }
}
