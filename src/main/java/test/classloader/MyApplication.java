package test.classloader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuping
 * @ClassName MyApplication
 * @Description
 * @since 2022/10/11 10:57
 */
public abstract class MyApplication {

//    protected static MyClassLoader CLASS_LOADER;

    private List<File> listClassFile(String projectPath) {
        return listClassFile(new File(projectPath));
    }

    private List<File> listClassFile(File file) {
        List<File> list = new ArrayList<>();
        if (file.isDirectory() ) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                list.addAll(listClassFile(file1));
            }
        } else {
            if (file.getName().endsWith(".class")) {
                list.add(file);
            }
        }
        return list;
    }

//    public MyApplication(String root) {
//        CLASS_LOADER = new MyClassLoader(root);
//        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//        System.out.println(systemClassLoader);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//
//
//                }
//            }
//        }).start();
//    }

//    void loadClass(String path) {
//        List<File> files = listClassFile(path);
//        for (File file : files) {
//            String[] split = file.getAbsolutePath().split("/classes/");
//            if (split.length > 1) {
//                fileMap.put(split[1].replace("/", "."), file);
//            }
//        }
//    }

    /**
     * 启动应用
     * @throws ClassNotFoundException
     */
    abstract void start() throws ClassNotFoundException;

    /**
     * 执行操作
     */
    abstract void exec();

    /**
     * 销毁应用
     */
    abstract void destroy();
}
