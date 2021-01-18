package ZUA.ys.design.adapter.InterfaceAdapter;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/18 11:18
 */
public interface Port {
    /**
     * 远程SSH端口为22
     */
    void SSH();

    /**
     * 网络端口为80
     */
    void NET();

    /**
     * Tomcat容器端口为8080
     */
    void Tomcat();

    /**
     * MySQL数据库端口为3306
     */
    void MySQL();
}
