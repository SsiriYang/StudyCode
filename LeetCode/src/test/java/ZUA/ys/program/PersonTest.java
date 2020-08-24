package ZUA.ys.program;

import org.junit.Test;

import java.util.Set;
import java.util.TreeMap;

/**
 * @Author 41765
 * @Creater 2020/2/12 14:50
 * Description
 */
public class PersonTest {

    @Test
    public void getsort(){
        TreeMap<Person, String> pdata = new TreeMap<Person, String>();
        pdata.put(new Person("张三", 30), "zhangsan");
        pdata.put(new Person("李四", 20), "lisi");
        pdata.put(new Person("王五", 10), "wangwu");
        pdata.put(new Person("小红", 5), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<Person> keys = pdata.keySet();
        for (Person key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());

        }
    }

}