package test;

/**
 * @author liuping
 * @ClassName WaitNotify
 * @Description
 * @since 2023/2/15 17:24
 */
public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "waitThread");
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new Notify(), "notifyThread");
        notifyThread.start();

    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (lock) {
//                lock.notifyAll();
//                flag = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println("线程:" + Thread.currentThread() + "开始执行");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("当前线程:" + Thread.currentThread() + "完成任务");
            }
        }
    }
}
