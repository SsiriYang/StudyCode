package ZUA.ys.program;

/**
 * @Author 41765
 * @Creater 2020/2/13 16:31
 * Description
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized ");
        }
    }
}