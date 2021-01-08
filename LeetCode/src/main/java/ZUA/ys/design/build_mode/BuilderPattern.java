package ZUA.ys.design.build_mode;

/**
 * Description
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性
 * @author YS
 * @date 2021/1/8 17:37
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        director.Construct(builder);
        Computer computer = builder.getComputer();
        computer.print();
    }
}
