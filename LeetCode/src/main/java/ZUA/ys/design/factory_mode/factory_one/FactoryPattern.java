package ZUA.ys.design.factory_mode.factory_one;

import ZUA.ys.design.factory_mode.MailSend;
import ZUA.ys.design.factory_mode.Sender;
import ZUA.ys.design.factory_mode.SmsSender;

/**
 * Description
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * @author YS
 * @date 2021/1/8 17:09
 */
public class FactoryPattern {
    public static void main(String[] args) {
        Sender sender = produce("mail");
        sender.send();
    }
    public static Sender produce(String str) {
        if ("mail".equals(str)) {
            return new MailSend();
        } else if ("sms".equals(str)) {
            return new SmsSender();
        } else {
            System.out.println("输入错误...");
            return null;
        }
    }
}
