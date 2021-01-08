package ZUA.ys.design.factory_mode.abstract_factory;

import ZUA.ys.design.factory_mode.Sender;
import ZUA.ys.design.factory_mode.SmsSender;

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
