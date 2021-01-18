package ZUA.ys.util.cmd;

/**
 * Description
 * shell执行的返回结果
 * @author YS
 * @date 2020/12/14 17:33
 */
public class ExecResult {
    /** 执行结果***/
    Boolean result;
    /** 返回内容***/
    String content;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String concent) {
        this.content = concent;
    }
}