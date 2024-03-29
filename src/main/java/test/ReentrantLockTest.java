package test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu ping
 * @date 2021/8/3 下午3:36
 */
public class ReentrantLockTest {



    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                while (!lock.tryLock()) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println("thread:"+ name+"获得了锁");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.unlock();

            }).start();
        }

    }
}
