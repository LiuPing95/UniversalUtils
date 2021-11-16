package test.threadpoll;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liu ping
 * @date 2021/8/12 下午2:28
 */
public class MyRejectPolicyHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("任务数量过多:"+r.toString());
        r.run();
//        if (!executor.isShutdown()) {
//            executor.execute(r);
//        }
    }

}
