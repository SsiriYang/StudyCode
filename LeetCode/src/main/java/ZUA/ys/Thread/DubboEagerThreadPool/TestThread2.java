package ZUA.ys.Thread.DubboEagerThreadPool;

import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author YS
 * @date 2021/3/24 10:23
 */
public class TestThread2 extends Thread {
    int i;
    public TestThread2(int i) {
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
