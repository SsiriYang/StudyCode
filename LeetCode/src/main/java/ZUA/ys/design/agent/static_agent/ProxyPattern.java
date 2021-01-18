package ZUA.ys.design.agent.static_agent;

/**
 * Description
 * 代理模式指给一个对象提供一个代理对象，并由代理对象控制对原对象的引用。代理可以分为静态代理和动态代理。
 * 通过代理模式，可以利用代理对象为被代理对象添加额外的功能，以此来拓展被代理对象的功能。可以用于计算某个方法执行时间，在某个方法执行前后记录日志等操作。
 *
 *
 * 静态代理需要我们写出代理类和被代理类，而且一个代理类和一个被代理类一一对应。
 * 代理类和被代理类需要实现同一个接口，通过聚合使得代理对象中有被代理对象的引用，以此实现代理对象控制被代理对象的目的。
 * @author YS
 * @date 2021/1/18 11:45
 */
public class ProxyPattern {
    public static void main(String[] args) {
        IService service = new Service();
        //传入被代理类的对象
        ProxyService proxyService = new ProxyService(service);
        proxyService.service();
    }
}
