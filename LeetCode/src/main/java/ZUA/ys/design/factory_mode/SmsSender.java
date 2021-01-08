package ZUA.ys.design.factory_mode;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/8 17:07
 */
public class SmsSender implements Sender {
    @Override
    public void send(){
        System.out.println("This is sms sender...");
    }
}
