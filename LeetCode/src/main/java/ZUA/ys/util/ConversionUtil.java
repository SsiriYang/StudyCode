package ZUA.ys.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 41765
 * @Creater 2020/7/20 10:55
 * Description 转化的工具类
 */
public class ConversionUtil {
    public static String test(String arg){
        if(StringUtils.equalsAny(arg,"1","2","3")){
            arg = "aaa";
        }
    return arg;
    }
    private static String[] spiltString(String a){
        String[] values ={};
        values = StringUtils.split(a,';');
        //values = a.split(";");
        return values;
    }
    public static void main(String[] args) {
       // System.out.println( test("2"));

//        Arrays.stream(spiltString("1;2")).forEach(s -> System.out.println(s));
//
//        for(String a : spiltString("1;2")){
//            System.out.println(a);
//        }
        Integer[] a ={1,2,3};
        List<Integer> a1 = new ArrayList<>();
        a1.addAll(Arrays.asList(a));
        Integer[] b = {4};
        List<Integer> b1 = new ArrayList<>();
        b1.addAll(Arrays.asList(b));
        //a1.stream().forEach(s->b1.add(s));
//        b1.stream().forEach(a12 -> System.out.println(a12));
        b1.addAll(a1);
        b1.stream().forEach(a12 -> System.out.println(a12));
        //System.out.println(spiltString("1;2")[1]);
    }
}
