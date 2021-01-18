package ZUA.ys.design.ornament;

/**
 * Description
 * 创建实现了 Shape 接口的抽象装饰类。
 * @author YS
 * @date 2021/1/18 11:25
 */
public abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
