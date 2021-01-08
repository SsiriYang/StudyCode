package ZUA.ys.design.build_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author YS
 * @date 2021/1/8 17:39
 */
public  class Computer {

    /**
     * 电脑组件集合
     */
    private List<String> parts = new ArrayList<String>();

    public void Add(String part) {
        parts.add(part);
    }

    public void print() {
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("组件:" + parts.get(i) + "装好了...");
        }
        System.out.println("电脑组装完毕...");
    }
}