package ZUA.ys.Authority;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author 41765
 * @Creater 2020/8/26 11:28
 * Description
 */
public enum MenuGroup {


    //一级菜单
    SCHEDULE_OVERVIEW(1,"调度概览"),
    TASK_MANAGEMENT(2,"任务管理"),
    SCHEDULE_PLAN(4,"调度计划"),
    PERFORM_MONITOR(8,"执行监控"),
    SYSTEM_CONTROL(16,"系统管控");

    private Integer authCode;
    private String menuName;

    private MenuGroup(Integer authCode, String menuName){
        this.authCode = authCode;
        this.menuName = menuName;
    }

    public Integer getAuthCode() {
        return authCode;
    }

    public String getMenuName(){
        return menuName;
    }


    /**
     * @Description  获取角色权限
     * @Param [code] 权限码共四位 规定前两位是菜单权限码 后两位是操作权限码
     * @return java.util.List<java.lang.String>
     */
    public static TreeMap<String, Integer> getMenuByCode(String code){
        //菜单权限码
        Integer menuCode = Integer.parseInt(code.substring(0,2));
        //操作权限码
        Integer operateCode = Integer.parseInt(code.substring(2,4));
        TreeMap<String, Integer> menus = new TreeMap<>();
        // 1.得到枚举类对象
        Class<Enum> clzMenuGroup = null;
        Class<Enum> clzOperate = null;
        try {
            clzMenuGroup = (Class<Enum>) Class.forName("ZUA.ys.Authority.MenuGroup");
            clzOperate = (Class<Enum>) Class.forName("ZUA.ys.Authority.OperateGroup");
            // 2.得到所有枚举常量
            Object[] objectsMenuGroup = clzMenuGroup.getEnumConstants();
            Object[] objectsOperate = clzOperate.getEnumConstants();
            Method getMenuName = clzMenuGroup.getMethod("getMenuName");
            Method getAuthCode = clzMenuGroup.getMethod("getAuthCode");
            Method getOperatorCode = clzOperate.getMethod("getOperatorCode");

            for (Object obj : objectsMenuGroup) {
                Integer enumMenuCode = Integer.valueOf(getAuthCode.invoke(obj).toString());
                //菜单鉴权
                if((menuCode&enumMenuCode)==enumMenuCode){
                    String menuName = getMenuName.invoke(obj).toString();
                    for(Object obj1 :objectsOperate){
                        Integer enumOperateCode = Integer.valueOf(getOperatorCode.invoke(obj1).toString());
                        //操作鉴权
                        if((operateCode&enumOperateCode) == enumOperateCode){
                            menus.put(menuName,enumOperateCode);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  menus;
    }
    public static void main(String[] args) {
        Map<String,Integer> menus =   MenuGroup.getMenuByCode("0202");
        System.out.println(menus.toString());
    }

}