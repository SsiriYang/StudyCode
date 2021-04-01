package ZUA.ys.data_tructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 *
 * @author YS
 * @date 2021/3/29 17:30
 */
public class TaskChain {

    int id;

    String status;

    List<TaskChain> body ;

    List<TaskChain> parent ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBody(List<TaskChain> body) {
        this.body = body;
    }

    TaskChain(Integer id, String status, List<TaskChain> body){
        this.id = id;
        this.status = status;
        this.body = body;
    }

    void getBody(){
        body.stream().forEach(a->System.out.println(a.getStatus()));
    }


    public static void main(String[] args) {
        List<TaskChain> parent = new ArrayList<>();
        List<TaskChain> body =new LinkedList<>();
        TaskChain End = new TaskChain(-1,"OVER",body);
        parent.add(End);
        body.add(End);
        TaskChain taskChain1 = new TaskChain(1,"SUCCESS",body);
        parent.add(taskChain1);
        body.clear();
        body.add(taskChain1);
        TaskChain Start = new TaskChain(0,"Running",body);
        parent.add(Start);
        parent.forEach(a->System.out.println(a.getId()) );
        decideTask(parent);
    }

    public static void decideTask(List<TaskChain> taskChains){
        List<TaskChain> taskChains1 = new ArrayList<>();
        taskChains.stream().filter(a->a.getStatus().equals("Running")).forEach(a->taskChains1.add(a));
        taskChains1.forEach(a->System.out.println(a.getStatus()));
    }
}
