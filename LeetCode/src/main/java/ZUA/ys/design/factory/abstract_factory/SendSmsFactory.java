package ZUA.ys.design.factory.abstract_factory;

import ZUA.ys.design.factory.Sender;
import ZUA.ys.design.factory.SmsSender;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/8 17:25
 */
public class SendSmsFactory implements Provider {

    @Override
    public Sender prduce() {
        return new SmsSender();
    }
}
