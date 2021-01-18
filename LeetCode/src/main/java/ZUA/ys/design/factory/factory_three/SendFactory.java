package ZUA.ys.design.factory.factory_three;

import ZUA.ys.design.factory.MailSend;
import ZUA.ys.design.factory.Sender;
import ZUA.ys.design.factory.SmsSender;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/8 17:17
 */
public class SendFactory {

    public static Sender produceMail() {
        return new MailSend();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.send();
    }
}
