package ZUA.ys.design.Singleton;

/**
 * @Author 41765
 * @Creater 2020/2/20 11:33
 * Description
 * 懒汉式(双重检查加锁版本)
 */
public class Singleton3 {
    //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理 uniqueInstance变量
    private Singleton3(){ }
    private volatile static Singleton3 uniqueInstance;
    public static Singleton3 getInstance(){
        //检查实例如果不存在，进入同步代码块
        if(uniqueInstance == null){
            synchronized (Singleton3.class){
                //进入同步代码块后，再检查一次，如果仍是null，才创建实例
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton3();
                }
            }
        }
        return uniqueInstance;
    }
}
