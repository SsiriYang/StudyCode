package ZUA.ys.design.adapter.InterfaceAdapter;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/18 11:21
 */
public class AdapterPattern {
    private static Port chatPort = new Chat();
    private static Port serverPort = new Server();

    public static void main(String[] args) {
        // 聊天服务
        chatPort.NET();

        // 服务器
        serverPort.SSH();
        serverPort.NET();
        serverPort.Tomcat();
        serverPort.MySQL();
    }
}
