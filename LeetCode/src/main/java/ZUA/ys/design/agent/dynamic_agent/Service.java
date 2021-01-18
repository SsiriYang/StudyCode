package ZUA.ys.design.agent.dynamic_agent;

/**
 * Description
 * 被代理类
 * @author YS
 * @date 2021/1/18 11:44
 */
public class Service implements IService {
    @Override
    public void service() {
        System.out.println("被代理对象执行相关操作");
    }
}
