package ZUA.ys.design.build;

/**
 * Description
 * 装机人员装机
 * @author YS
 * @date 2021/1/8 17:40
 */
public class Director {
    public void Construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainBoard();
        builder.buildHD();
    }
}