package ZUA.ys.design.observer;

/**
 * @Author 41765
 * @Creater 2020/2/20 11:08
 * Description
 * 观察者模式这种发布-订阅的形式我们可以拿微信公众号来举例，
 * 假设微信用户就是观察者，微信公众号是被观察者，有多个的微信用户关注了程序猿这个公众号，
 * 当这个公众号更新时就会通知这些订阅的微信用户。好了我们来看看用代码如何实现：
 */

public interface Observer {
    //当主题状态改变时,更新通知
    public void update(int  version);
}
