package ZUA.ys.design.Observer_mode;

/**
 * @Author 41765
 * @Creater 2020/2/20 11:10
 * Description
 * 抽象被观察者
 */
public interface Subject {
    /**
     * 增加订阅者
     * @param observer
     */
    public void addObserver(Observer observer);
    /**
     * 删除订阅者
     * @param observer
     */
    public void deleteObserver(Observer observer);
    /**
     * 通知订阅者更新消息
     */
    public void notifyObserver();
}
