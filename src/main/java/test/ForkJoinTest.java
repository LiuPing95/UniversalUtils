package test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author liu ping
 * @Version 1.x.0
 * @Description
 * @Date 2020/3/12 4:39 PM
 **/
public class ForkJoinTest {

    /**
     * 子任务在同一时刻执行
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        RecursiveTask<Integer> recursiveTask1 = new RecursiveTask<Integer>() {
            @Override
            protected Integer compute() {
                RecursiveTask<Integer> recursiveTask2 = new RecursiveTask<Integer>() {
                    @Override
                    protected Integer compute() {
                        return 1 + 2;
                    }
                };
                RecursiveTask<Integer> recursiveTask3 = new RecursiveTask<Integer>() {
                    @Override
                    protected Integer compute() {
                        return 3 + 4;
                    }
                };
                recursiveTask2.fork();
                recursiveTask3.fork();
                Integer i1;
                Integer i2;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (recursiveTask2.isCompletedAbnormally()) {
                    i1 = 0;
                    System.out.println("计算出错");
                } else {
                    i1 = recursiveTask2.join();

                }
                i2 = recursiveTask3.join();
                return i1 + i2;
            }
        };


        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> task = forkJoinPool.submit(recursiveTask1);
        Integer result = task.get();
        System.out.println(result);

    }
}
