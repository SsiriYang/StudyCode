package ZUA.ys.design.factory.abstract_factory;

import ZUA.ys.design.factory.MailSend;
import ZUA.ys.design.factory.Sender;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/8 17:24
 */
public class SendMailFactory implements Provider {

    @Override
    public Sender prduce() {
        return new MailSend();
    }
}
