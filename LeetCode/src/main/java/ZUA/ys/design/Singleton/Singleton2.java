package ZUA.ys.design.Singleton;

/**
 * @Author 41765
 * @Creater 2020/2/20 11:28
 * Description
 * 懒汉式加载单例模式
 */
public class Singleton2 {
    //私有的默认构造方法
    private Singleton2(){}
    //注意 懒汉式加载这里没有final
    private static  Singleton2 single = null;
    //静态工厂的方法
     public synchronized static Singleton2 getInstance(){
         if(single==null){
             single = new Singleton2();
         }
         return  single;
     }
}
