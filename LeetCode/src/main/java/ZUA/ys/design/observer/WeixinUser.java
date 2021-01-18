package ZUA.ys.design.observer;

/**
 * @Author 41765
 * @Creater 2020/2/20 11:09
 * Description
 */
public class WeixinUser implements Observer {
    // 微信用户名
    private String name;
    private int version;
    public WeixinUser(String name) {
        this.name = name;
    }
    @Override
    public void update(int version) {
        this.version=version;
        System.out.println("该作者更新了");
        this.buy();
    }
    public void buy(){
        System.out.println(name+"查看了第"+version+"篇文章!");
    }
}
