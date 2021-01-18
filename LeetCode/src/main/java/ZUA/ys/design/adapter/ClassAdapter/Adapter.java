package ZUA.ys.design.adapter.ClassAdapter;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/18 11:03
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("This is the targetable method...");
    }
}
