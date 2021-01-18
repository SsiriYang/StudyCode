package ZUA.ys.design.ornament;

/**
 * Description
 * 创建扩展自 ShapeDecorator 类的实体装饰类。
 * @author YS
 * @date 2021/1/18 11:26
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
