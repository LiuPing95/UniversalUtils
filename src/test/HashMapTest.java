package test;

import java.util.concurrent.*;

/**
 * @Author liu ping
 * @Version 1.x.0
 * @Description
 * @Date 2020/3/4 2:28 PM
 **/
public class HashMapTest {


    public static void main(String[] args) throws InterruptedException {

//        ExecutorService
        new ThreadPoolExecutor(5,10, 1000,TimeUnit.HOURS, new LinkedBlockingDeque());
        Executors.newFixedThreadPool(1);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(10);
        /*String a = "a";
        String b = "b";
        String c = "a" + b;
        String d = "ab";
        String e = "a" + "b";
        System.out.println(c.intern()==d);*/
        /*final HashMap<String, String> map = new HashMap<>(2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    Thread thread1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "thread" + i);
                    thread1.start();
//                    System.out.println(thread1.getName());

                }
            }
        });
        thread.start();
        thread.join();*/

    }

}
