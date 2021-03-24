package ZUA.ys.Thread.DubboEagerThreadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description
 *
 * @author YS
 * @date 2021/3/23 14:59
 */
public class MyRejectPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //Sender是我的Runnable类，里面有message字段
        System.out.println("拒绝策略");
//        if (r instanceof MyRunnable) {
//            MyRunnable sender = (MyRunnable) r;
//            //直接打印
//            System.out.println("拒绝策略"+sender.toString());
//        }
    }
}
