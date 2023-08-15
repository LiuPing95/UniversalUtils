package test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuping
 * @ClassName Test
 * @Description
 * @since 2023/3/3 16:50
 */
public class Test1 {

    private int num = 0;

    public static void main(String[] args) throws InterruptedException {
        // 使用synchronized锁对象,保证了对象一次只能被一个线程获取
        Test1 test1 = new Test1();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (test1) {
                        System.out.println(Thread.currentThread().getName() + ":"+ test1.num);
                        test1.num = test1.num + 1;
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        countDownLatch.countDown();
                    }
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(test1.num);
    }

    public void test(byte i) {
        switch (i) {

        }
        short s1 = 1;
        short s2 = 2;
        s1 += 1;

    }

}
