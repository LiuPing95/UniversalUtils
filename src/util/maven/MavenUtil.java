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
public class MavenUtil
{

    private static int delFileCount     = 0;
    private static int needDelFileCount = 0;
    private static int fileCount        = 0;
    private static int dirCount         = 0;
    private static int delDirCount      = 0;

    private MavenUtil()
    {
    }

    public static void main(String[] args) throws IOException
    {
        delLastUpdateFile("D:\\maven\\repository");
    }

    /**
     * 删除目录下的.lastUpdate的文件
     *
     * @param mavenPath
     */
    public static void delLastUpdateFile(String mavenPath) throws IOException
    {
        File root = new File(mavenPath);
        if (root.isDirectory())
        {
            delFileOfDir(root);
        }
        System.out.println(fileCount);
        System.out.println(dirCount);
        System.out.println(needDelFileCount);
        System.out.println(delFileCount);
        System.out.println(delDirCount);
    }

    private static void delFileOfDir(File dir) throws IOException
    {
        String fileSuffix  = ".lastUpdated";
        String fileSuffix1 = ".sha1___";
        File[] files       = dir.listFiles();
        if (files == null)
        {
            return;
        }
        for (File file : files)
        {
            if (file.isDirectory())
            {
                dirCount++;
                if ("unknown".equals(file.getName()))
                {
                    delDirCount++;
                    delDir(file);

                }
                else
                {
                    delFileOfDir(file);
                }
            }
            else
            {
                fileCount++;
                if (file.getName()
                        .endsWith(fileSuffix) || file.getName()
                                                     .endsWith(fileSuffix1))
                {
                    needDelFileCount++;
                    Path path = Paths.get(file.toURI());
                    // 如果没有权限删除会报错，但是调用File.delete()的话是不会报错的
                    boolean delete = Files.deleteIfExists(path);
                    if (delete)
                    {
                        delFileCount++;
                    }
                }
            }
        }
    }

    private static void delDir(File file)
    {
        File[] files = file.listFiles();
        for (File f : files)
        {
            if (f.isDirectory())
            {
                delDir(f);
            }
            else
            {
                f.delete();
            }
        }
        file.delete();
    }
}
