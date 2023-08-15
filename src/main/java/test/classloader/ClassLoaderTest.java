package test.classloader;

import java.lang.reflect.Method;

/**
 * @author liuping
 * @ClassName ClassLoaderTest
 * @Description
 * @since 2022/10/11 10:55
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        while (true) {
            System.gc();
            Thread.sleep(2000L);
            MyClassLoader myClassLoader = new MyClassLoader("/Users/liuping/Desktop/workspace/UniversalUtils/out/production/UniversalUtils");
//            Class<?> aClass = Class.forName("test.classloader.PlayerApplication", false, myClassLoader);
            Class<?> aClass = myClassLoader.loadClass("test.classloader.PlayerApplication");
//            Class<?> aClass = myClassLoader.findClass("test.classloader.PlayerApplication");

            Object o = aClass.newInstance();
            Method exec = aClass.getMethod("exec");
            exec.invoke(o);
        }


        //        aClass.newInstance().;
//        playerApplication.start();
//        playerApplication.exec();
//        ClassLoader classLoader = aClass.getClassLoader();
//        while (classLoader.getParent() != null) {
//            System.out.println(classLoader);
//            classLoader = classLoader.getParent();
//        }
//        System.out.println(classLoader);
//        System.out.println(Thread.currentThread().getContextClassLoader());
//        System.out.println(aClass.getClassLoader());
//        System.out.println(String.class.getClassLoader());
    }
}
