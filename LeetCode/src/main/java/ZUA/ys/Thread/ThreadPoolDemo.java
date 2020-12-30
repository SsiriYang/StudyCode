package ZUA.ys.Thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description
 corePoolSize： 线程池核心线程数
 maximumPoolSize：线程池最大数
 keepAliveTime： 空闲线程存活时间
 unit： 时间单位
 workQueue： 线程池所使用的缓冲队列
 threadFactory：线程池创建线程使用的工厂
 handler： 线程池对拒绝任务的处理策略
 * @author YS
 * @date 2020/12/2 17:04
 */
public class ThreadPoolDemo {

    // 线程数
    public static final int THREAD_POOL_SIZE = 16;

    public static void main(String[] args) {
        //demo();
        //demo1();
        //demo2();
        //demo3();
        demo4();
    }

    public static void demo(){
        // 使用 ThreadFactoryBuilder 创建自定义线程名称的 ThreadFactory
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("hyn-demo-pool-%d").build();
        // 创建线程池，其中任务队列需要结合实际情况设置合理的容量
        ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_SIZE,
                THREAD_POOL_SIZE,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        // 新建 1000 个任务，每个任务是打印当前线程名称
        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        // 优雅关闭线程池
        executor.shutdown();
        try {
            executor.awaitTermination(1000L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 任务执行完毕后打印"Done"
        System.out.println("Done");
    }

    /**
     * 特性一：当池中正在运行的线程数（包括空闲线程）小于corePoolSize时，新建线程执行任务。
     * @return : void
     **/
    public static void demo1(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1));
        //任务1
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_001---------------" + Thread.currentThread().getName());
            }
        });

        try {
            //主线程睡2秒
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //任务2
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_002---------------" + Thread.currentThread().getName());
            }
        });
    }

    /**
     * 特性二：当池中正在运行的线程数大于等于corePoolSize时，新插入的任务进入workQueue排队（如果workQueue长度允许），等待空闲线程来执行。
     * @return : void
     **/
    public static void demo2(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        // 任务1
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3 * 1000);
                    System.out.println("-------------helloworld_001---------------" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 任务2
        pool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                    System.out.println("-------------helloworld_002---------------" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 任务3
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_003---------------" + Thread.currentThread().getName());
            }
        });

    }
    /**
     *
     当队列里的任务数达到上限，并且池中正在运行的线程数小于maximumPoolSize，对于新加入的任务，新建线程。
     * @return : void
     **/
    public static void demo3(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        // 任务1
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3 * 1000);
                    System.out.println("-------------helloworld_001---------------" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 任务2
        pool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                    System.out.println("-------------helloworld_002---------------" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 任务3
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_003---------------" + Thread.currentThread().getName());
            }
        });

        // 任务4
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_004---------------" + Thread.currentThread().getName());
            }
        });
    }

    /** 
     *
     当队列里的任务数达到上限，并且池中正在运行的线程数等于maximumPoolSize，对于新加入的任务，执行拒绝策略（线程池默认的拒绝策略是抛异常）。
     * @return : void
     **/
    public static   void  demo4(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        // 任务1
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3 * 1000);
                    System.out.println("-------------helloworld_001---------------" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 任务2
        pool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                    System.out.println("-------------helloworld_002---------------" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 任务3
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_003---------------" + Thread.currentThread().getName());
            }
        });

        // 任务4
        pool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------------helloworld_004---------------" + Thread.currentThread().getName());
            }
        });

        // 任务5
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_005---------------" + Thread.currentThread().getName());
            }
        });
    }
}