package ZUA.ys.design.adapter.ClassAdapter;

/**
 * Description
 * 适配器模式是将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的的类的兼容性问题。
 * 主要分三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 * @author YS
 * @date 2021/1/18 11:02
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }
}
