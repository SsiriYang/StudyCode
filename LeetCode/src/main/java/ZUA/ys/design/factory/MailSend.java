package ZUA.ys.design.factory;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/8 17:07
 */
public class MailSend implements Sender {
    @Override
    public void send(){
        System.out.println("This is mail sender...");
    }
}
