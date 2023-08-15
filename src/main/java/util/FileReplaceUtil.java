package util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu ping
 * @date 2020/4/27 4:42 下午
 */
public class FileReplaceUtil {

    public static String dir = "/Users/liuping/Desktop/xxljob";

    public static File[] files;

    public static void main(String[] args) throws IOException {

        ExecutorService threadPool = Executors.newFixedThreadPool(6);

        File dir = new File(FileReplaceUtil.dir);
        if (dir != null) {
            // 读取目录下的文件
            files = dir.listFiles();
            for (File file : files) {
                threadPool.execute(new FileTask(file));
//                break;
            }
        }
        threadPool.shutdown();
    }

    public static class FileTask implements Runnable {

        private File file;

        public FileTask(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            if (file.length() == 0) {
                return;
            }
            String fileName = file.getName();
            if (".DS_Store".equals(fileName)) {
                return;
            }
            RandomAccessFile rw = null;
            FileOutputStream fileOutputStream = null;
            OutputStreamWriter outputStreamWriter = null;
            try {
                String replaceStr = null;

                rw = new RandomAccessFile(file, "r");
                fileOutputStream = new FileOutputStream(new File(dir + "/new_" + fileName));
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.ISO_8859_1);
                StringBuffer result = new StringBuffer();

                String line;
                while ((line = rw.readLine()) != null) {
                    if (replaceStr == null) {
                        int dtc_ = line.indexOf("xxl_job_");
                        int i = line.indexOf(".");
                        if (dtc_ != -1 && i != -1) {
                            replaceStr = line.substring(dtc_, i + 1);
                        }
                    }
                    line = line.replaceAll(replaceStr, "");
                    result.append(line + "\n");
                }

                outputStreamWriter.write(result.toString());
            } catch (IOException e) {
                System.err.println(fileName);
            } finally {
                try {
                    rw.close();
                    // 先关闭这个会导致文件可能写不完
//                    fileOutputStream.close();
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
