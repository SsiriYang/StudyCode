package ZUA.ys.design.factory.abstract_factory;

import ZUA.ys.design.factory.Sender;

/**
 * Description
 * 工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要扩展程序，必须对工厂类进行修改，这违背了闭包原则，所以，从设计角度考虑，有一定的问题，如何解决？
 * 那么这就用到了抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码
 * @author YS
 * @date 2021/1/8 17:26
 */
public class FactoryPattern {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender =  provider.prduce();
        sender.send();
    }
}
