package test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu ping
 * @date 2021/5/17 下午5:07
 */
public class ThreadTest {

    public static final Map<String, String> map = new HashMap<>();


    public static void main(String[] args) throws InterruptedException {

        System.out.println(Runtime.getRuntime().availableProcessors());

        // 多线程读取磁盘文件
//        File file = new File("/");
//        boolean directory = file.isDirectory();
//        File[] files = file.listFiles();
//        for (File file1 : files) {
//            countFile(file1);
//        }
    }

    public static int countFile(File file) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && file.length() > 0) {
                return files.length;
            }
            return 0;
        }
        return 1;
    }
}
