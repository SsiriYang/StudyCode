package ZUA.ys.Thread.DubboEagerThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description
 *
 * @author YS
 * @date 2021/3/23 14:32
 */
public class EagerThreadPoolExecutor extends ThreadPoolExecutor {

    /**
     * 定义一个成员变量，用于记录当前线程池中已提交的任务数量
     */
    private final AtomicInteger submittedTaskCount = new AtomicInteger(0);

    public EagerThreadPoolExecutor(int corePoolSize,
                                   int maximumPoolSize,
                                   long keepAliveTime,
                                   TimeUnit unit, TaskQueue<Runnable> workQueue,
                                   ThreadFactory threadFactory,
                                   RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    /**
     * 获取当前线程池已提交的线程数量
     * @return : int
     **/
    public int getSubmittedTaskCount() {
        return submittedTaskCount.get();
    }

    /** 
     * 重写ThreadPoolExecutor的勾子方法，在task执行完后需要将池中已提交的任务数 - 1
     * @param r : 
     * @param t : 
     * @return : void
     **/
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        submittedTaskCount.decrementAndGet();
    }

    /**
     * 任务执行
     * @param command :
     * @return : void
     **/
    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }
        // do not increment in method beforeExecute!
        // 将池中已提交的任务数 + 1
        submittedTaskCount.incrementAndGet();
        try {
            super.execute(command);
        } catch (RejectedExecutionException rx) {
            // retry to offer the task into queue.
            final TaskQueue<Runnable> queue = (TaskQueue) super.getQueue();
            try {
                if (!queue.retryOffer(command, 0, TimeUnit.MILLISECONDS)) {
                    submittedTaskCount.decrementAndGet();
                    throw new RejectedExecutionException("Queue capacity is full.", rx);
                }
            } catch (InterruptedException x) {
                submittedTaskCount.decrementAndGet();
                throw new RejectedExecutionException(x);
            }
        } catch (Throwable t) {
            // decrease any way
            submittedTaskCount.decrementAndGet();
            throw t;
        }
    }
}
