package ZUA.ys.design.Singleton;

/**
 * @Author 41765
 * @Creater 2020/2/20 11:25
 * Description
 * 饿汉式加载单例模式
 */
public class Singleton1 {
    //私有的默认构造方法
    private Singleton1(){}
    //自行实例化
    private  static final Singleton1 single = new Singleton1();
    //静态工厂的方法
    public static Singleton1 getInstance(){
        return  single;
    }
}
