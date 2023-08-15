package test.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liuping
 * @ClassName Test3
 * @Description
 * @since 2023/3/3 17:50
 */
public class Test3 {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10, true);
        for (int i = 0; i < 10; i++) {
            queue.put(i);
        }
        System.out.println("当前票数:" + queue.size());
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {

                Integer poll = null;
                try {
                    poll = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + poll);
            }).start();
        }
        Thread.sleep(1000L);
        System.out.println("当前票数:" + queue.size());

        for (int i = 10; i < 20; i++) {
            queue.put(i);
        }
        System.out.println("当前票数:" + queue.size());
        Thread.sleep(1000L);


    }

    static class Ticket {
        private int count = 100;
    }

    static class Tourist {
        public void buyTicket(int sum) {

        }
    }

    static class TicketSeller {
        public void ticket() {

        }
    }
}
