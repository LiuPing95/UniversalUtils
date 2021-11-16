package test;

import java.util.concurrent.Semaphore;

/**
 * @author liu ping
 * @date 2020/9/2 3:06 下午
 */
public class SemaphoreTest {


    public static void main(String[] args) {
        PrintSample printSample = new PrintSample();

//        new Thread(() -> printSample.first()).start();
//        new Thread(() -> printSample.second()).start();
//        new Thread(() -> printSample.third()).start();

        FooBarPrint fooBarPrint = new FooBarPrint();
        int i = 10;
        new Thread(() -> {
            for (int i1 = 0; i1 < i; i1++) {
                fooBarPrint.foo();
            }
        }).start();
        new Thread(() -> {
            for (int i1 = 0; i1 < i; i1++) {
                fooBarPrint.bar();
            }
        }).start();

    }

    public static class FooBarPrint {
        private Semaphore semaphore1 = new Semaphore(0);
        private Semaphore semaphore2 = new Semaphore(0);

        public void foo() {
            System.out.print("Foo");
            semaphore1.release();
        }

        public void bar() {
            try {
                semaphore1.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Bar");
            semaphore1.release();
        }
    }

    /**
     * 一开始 信号量为0，知道调用了release之后 产生了一个可用的信号量 second可以获得信号量，否则为0的时候是不能获的。
     * 利用这一点，用release来产生信号量，控制输出顺序
     */
    public static class PrintSample {
        private Semaphore semaphore1 = new Semaphore(0);
        private Semaphore semaphore2 = new Semaphore(0);

        public void first() {
            System.out.println("first");
            semaphore1.release();
        }

        public void second() {
            try {
                semaphore1.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("second");
            semaphore2.release();
        }

        public void third() {
            try {
                semaphore2.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("third");
        }
    }

}
