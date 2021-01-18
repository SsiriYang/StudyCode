package ZUA.ys.design.strategy;

/**
 * Description
 * 上下文，维护一个对策略类对象的引用
 * @author YS
 * @date 2021/1/18 11:36
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface(){
        strategy.AlgorithmInterface();
    }
}
