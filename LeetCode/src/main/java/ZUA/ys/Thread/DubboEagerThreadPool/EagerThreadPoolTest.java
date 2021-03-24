package ZUA.ys.Thread.DubboEagerThreadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author YS
 * @date 2021/3/23 14:55
 */
public class EagerThreadPoolTest {
    public static void main(String[] args) {
        TaskQueue queue = new TaskQueue(2);
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("EagerThreadPoolTest-pool-%d").build();
        EagerThreadPoolExecutor threadPool = new EagerThreadPoolExecutor(1, 2,
                60, TimeUnit.SECONDS,
                queue,threadFactory,new MyRejectPolicy());
        queue.setExecutor(threadPool);
        threadPool.execute(new TestThread(1));
        threadPool.execute(new TestThread(2));
        threadPool.execute(new TestThread2(3));
        threadPool.execute(new TestThread(4));
        threadPool.execute(new TestThread(5));
        threadPool.execute(new TestThread(6 ));
        threadPool.shutdown();
    }
}
