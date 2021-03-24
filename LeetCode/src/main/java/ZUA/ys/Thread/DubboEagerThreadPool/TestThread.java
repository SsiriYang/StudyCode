package ZUA.ys.Thread.DubboEagerThreadPool;

import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author YS
 * @date 2021/3/23 15:19
 */
public class TestThread implements Runnable{
    int i;
    public TestThread(int i) {
        this.i = i;
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("第"+i+"个"+"线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
