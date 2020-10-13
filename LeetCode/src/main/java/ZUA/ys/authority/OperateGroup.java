package ZUA.ys.authority;

/**
 * @Author YS
 * @Creater 2020/8/26 15:55
 * Description
 */
public enum OperateGroup {
    Add(1),
    Update(2),
    Delete(4),
    Select(8);
    private Integer code;
    private OperateGroup(Integer code){
        this.code = code;
    }
    public Integer getOperatorCode() {
        return code;
    }
}
