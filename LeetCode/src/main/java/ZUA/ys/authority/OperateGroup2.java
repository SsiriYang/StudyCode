package ZUA.ys.authority;

/**
 * @Author YS
 * @Creater 2020/8/26 15:55
 * Description
 */
public enum OperateGroup2 {
    Add(01),
    Update(10),
    Delete(11);
    private Integer code;
    private OperateGroup2(Integer code){
        this.code = code;
    }
    public Integer getOperatorCode() {
        return code;
    }
}
