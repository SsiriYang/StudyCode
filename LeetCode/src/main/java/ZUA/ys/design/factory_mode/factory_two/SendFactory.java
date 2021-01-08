package ZUA.ys.design.factory_mode.factory_two;

import ZUA.ys.design.factory_mode.MailSend;
import ZUA.ys.design.factory_mode.Sender;
import ZUA.ys.design.factory_mode.SmsSender;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/8 17:13
 */
public class SendFactory {
    public Sender produceMail() {
        return new MailSend();
    }

    public Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.send();
    }
}
