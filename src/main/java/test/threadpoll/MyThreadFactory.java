package test.threadpoll;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu ping
 * @date 2021/8/12 下午2:27
 */
public class MyThreadFactory implements ThreadFactory {

    private AtomicInteger name = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        int i = name.incrementAndGet();
        System.out.println("创建线程："+i);
        thread.setName(i + "");
        return thread;
    }

}
