package ZUA.ys.design.adapter.ObjectAdapter;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/18 11:13
 */
public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("This is the targetable method...");
    }
}
