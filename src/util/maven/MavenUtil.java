package util.maven;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description
 * @Author liuping
 * @Date 2019/7/23 13:40
 * @Version 1.0
 */
public class MavenUtil {

    private static int delFileCount = 0;
    private static int needDelFileCount = 0;
    private static int fileCount = 0;
    private static int dirCount = 0;
    private static int delDirCount = 0;

    private MavenUtil() {
    }

    public static void main(String[] args) throws IOException {
        delLastUpdateFile("/Users/liuping/.m2/repository");
    }

    /**
     * 删除目录下的.lastUpdate的文件
     *
     * @param mavenPath
     */
    public static void delLastUpdateFile(String mavenPath) throws IOException {
        File root = new File(mavenPath);
        if (root.isDirectory()) {
            delFileOfDir(root);
        }
        System.out.println("fileCount\t\t\t:\t" + fileCount);
        System.out.println("dirCount\t\t\t:\t" + dirCount);
        System.out.println("needDelFileCount\t:\t" + needDelFileCount);
        System.out.println("delFileCount\t\t:\t" + delFileCount);
        System.out.println("delDirCount\t\t\t:\t" + delDirCount);
    }

    private static void delFileOfDir(File dir) throws IOException {
        String fileSuffix1 = ".lastUpdated";
        String fileSuffix2 = ".sha1___";
        String fileSuffix3 = "unknown";
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        if (files.length == 0) {
            boolean delete = Files.deleteIfExists(Paths.get(dir.toURI()));
            if (delete) {
                delDirCount++;
            }
            return;
        }
        for (File file : files) {
            String fileName = file.getName();
            if (file.isDirectory()) {
                dirCount++;
                if ("unknown".equals(fileName) || "error".equals(fileName)) {
                    delDirCount++;
                    delDir(file);

                } else {
                    delFileOfDir(file);
                }
            } else {
                fileCount++;
                if (fileName.endsWith(fileSuffix1)
                        || fileName.endsWith(fileSuffix2)
                        || fileName.contains(fileSuffix3)) {
                    needDelFileCount++;
                    Path path = Paths.get(file.toURI());
                    // 如果没有权限删除会报错，但是调用File.delete()的话是不会报错的
                    boolean delete = Files.deleteIfExists(path);
                    if (delete) {
                        delFileCount++;
                    }
                }
            }
        }
    }

    private static void delDir(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                delDir(f);
            } else {
                f.delete();
            }
        }
        file.delete();
    }
}
