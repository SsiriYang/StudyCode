package ZUA.ys.design.Singleton;

/**
 * @Author 41765
 * @Creater 2020/2/20 11:39
 * Description
 * 静态内部类方式
 */
public class Singleton4 {
    private static class Singletonholder{
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    private Singleton4(){}
    public static final Singleton4 getInstance(){
        return Singletonholder.INSTANCE;
    }
}
