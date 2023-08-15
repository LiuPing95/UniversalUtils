package test.threadpoll;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liu ping
 * @date 2021/8/12 下午2:39
 */
public class MyBlockQueue extends LinkedBlockingQueue<Runnable> {

    @Override
    public boolean offer(Runnable runnable) {
        if (this.size() >= 5) {
            return false;
        }
        boolean offer = super.offer(runnable);
        System.out.println("添加任务:"+runnable.toString());
        return offer;
    }

    @Override
    public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
        Runnable task = super.poll(timeout, unit);
        System.out.println("取出任务："+task.toString());
        return task;
    }
}
