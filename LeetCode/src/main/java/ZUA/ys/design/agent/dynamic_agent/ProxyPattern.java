package ZUA.ys.design.agent.dynamic_agent;

import java.lang.reflect.Proxy;

/**
 * Description
 * JDK 1.3 之后，Java通过java.lang.reflect包中的三个类Proxy、InvocationHandler、Method来支持动态代理。动态代理常用于有若干个被代理的对象，且为每个被代理对象添加的功能是相同的（例如在每个方法运行前后记录日志）。
 *
 * 动态代理的代理类不需要我们编写，由Java自动产生代理类源代码并进行编译最后生成代理对象。
 * 创建动态代理对象的步骤：
 * 1. 指明一系列的接口来创建一个代理对象
 * 2. 创建一个调用处理器（InvocationHandler）对象
 * 3. 将这个代理指定为某个其他对象的代理对象
 * 4. 在调用处理器的invoke（）方法中采取代理，一方面将调用传递给真实对象，另一方面执行各种需要的操作
 * @author YS
 * @date 2021/1/18 11:50
 */
public class ProxyPattern {
    public static void main(String[] args) {
        IService service = new Service();
        Class<? extends IService> clazz = service.getClass();

        IService proxyService = (IService) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(), new ServiceInvocationHandler(service));
        proxyService.service();
    }
}
