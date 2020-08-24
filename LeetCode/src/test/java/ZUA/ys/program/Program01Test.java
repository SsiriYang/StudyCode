package ZUA.ys.program;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author 41765
 * @Creater 2020/2/11 22:12
 * Description
 */
public class Program01Test {

    @Test
    public void getmin() {
    int minInteger =Program01.min(new Integer[]{1, 2, 3});//result:1
    System.out.println(minInteger);
    double minDouble = Program01.min(new Double[]{1.2, 2.2, -1d});//result:-1d
    System.out.println(minDouble);
    //String typeError = Program01.min(new String[]{"1","3"});//报错
    }

    //反射用法
    @Test
    public void getinsta(){
        try {
            // 创建字符串"Hello World"， 并赋给引用s
            String s = "Hello World";

            System.out.println("s = " + s); // Hello World

            // 获取String类中的value字段
            Field valueFieldOfString = String.class.getDeclaredField("value");

            // 改变value属性的访问权限
            valueFieldOfString.setAccessible(true);

            // 获取s对象上的value属性的值
            char[] value = (char[]) valueFieldOfString.get(s);

            // 改变value所引用的数组中的第5个字符
            value[5] = '_';

            System.out.println("s = " + s); // Hello_World
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    //Comparator定制排序
    @Test
    public void getsort(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);
        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);
    }
}