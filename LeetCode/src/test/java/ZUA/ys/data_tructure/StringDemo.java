package ZUA.ys.data_tructure;

import org.junit.Test;

/**
 * @Author 41765
 * @Creater 2020/2/13 15:34
 * Description
 * String 中的 equals 方法是被重写过的，因为 object 的 equals 方法是比较的对象的内存地址，而 String 的 equals 方法比较的是对象的值。
 * 当创建 String 类型的对象时，虚拟机会在常量池中查找有没有已经存在的值和要创建的值相同的对象，如果有 就把它赋给当前引用。如果没有就在常量池中重新创建一个 String 对象
 */
public class StringDemo {

    //一、判断String类型的s1和s2是否相等
    @Test
    public  void S1() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);   //true

        System.out.println(s1.equals(s2)); //true
    }
    //二、下面这句话创建了几个对象
    @Test
    public void S2(){
        //创建了两个对象，一个在常量池中，一个在堆内存中
        String S1 = new String("abc");
    }
    //三、判断定义为String类型的s1和s2是否相等
    @Test
    public void S3(){
        //创建了两个对象，一个在常量池中，一个在堆内存中
        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1 == s2);   //false
        System.out.println(s1.equals(s2));   //true
        //原因：s1记录的是堆内存中对象的地址，s2记录的是常量池中的地址
    }
    //四、判断定义为String类型的s1和s1是否相等
    @Test
    public void S4(){
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);        //true
        System.out.println(s1.equals(s2));   //true

        //原因：java中有常量优化机制，编译时就把 "a" + "b" + "c"变成“abc”赋值给s1
    }
    //五、判断定义为String类型的s1和s2是否相等
    @Test
    public void S5(){
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        System.out.println(s3 == s2);            //false
        System.out.println(s3.equals(s2));       //true

    }
}
