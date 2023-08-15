package test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuping
 * @ClassName Test2
 * @Description  使用可重入锁,获取锁的时候不会阻塞,如果没有获取到就直接返回.
 *               可以带等待时间的锁
 * @since 2023/3/3 17:32
 */
public class Test2 {

    private int num;

    public static void main(String[] args) throws InterruptedException {
        Test2 test2 = new Test2();
        ReentrantLock reentrantLock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println("线程"+name+"开始执行");
                    try {
                        if (reentrantLock.tryLock(1, TimeUnit.SECONDS)) {
                            try{
                                System.out.println(name +":"+test2.num);
                                test2.num = test2.num + 1;
                            }
                            finally {
                                reentrantLock.unlock();
                            }
                        } else {
                            System.out.println("线程"+name+"没有获取到锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(test2.num);
    }
}
