package test.threadpoll;

import java.util.concurrent.*;

/**
 * @author liu ping
 * @date 2020/4/27 8:26 下午
 */
public class ThreadPoolTest {


    public static volatile Integer i = 0;

    public static void main(String[] args) {

        BlockingQueue<Runnable> blockingQueue = new MyBlockQueue();

        RejectedExecutionHandler rejectedExecutionHandler = new MyRejectPolicyHandler();
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1,
                        10,
                        1L, TimeUnit.SECONDS,
                        blockingQueue, new MyThreadFactory(), rejectedExecutionHandler);

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(new ThreadTestTask(ThreadPoolTest.i++));
        }
        threadPoolExecutor.shutdown();
    }


    public static class ThreadTestTask implements Runnable {

        private int i;

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


        public ThreadTestTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            threadLocal.set(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread no：" + Thread.currentThread().getName() + "-> current task no：" + i);
        }

        @Override
        public String toString() {
            return "ThreadTestTask{" +
                    "i=" + i +
                    '}';
        }
    }
}
