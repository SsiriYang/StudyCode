package ZUA.ys.design.observer_mode;

/**
 * @Author 41765
 * @Creater 2020/2/20 11:11
 * Description
 * 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        MagazineSubject magazine = new MagazineSubject();
        //创建微信用户
        WeixinUser user1=new WeixinUser("杨影枫");
        WeixinUser user2=new WeixinUser("月眉儿");
        WeixinUser user3=new WeixinUser("紫轩");
        //订阅公众号
        magazine.addObserver(user1);
        magazine.addObserver(user2);
        magazine.addObserver(user3);
        //公众号更新发出消息给订阅的微信用户
        magazine.publish();
    }
}
