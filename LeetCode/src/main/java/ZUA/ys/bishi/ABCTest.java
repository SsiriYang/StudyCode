package ZUA.ys.bishi;

import java.util.Scanner;

/**
 * @Author 41765
 * @Creater 2020/3/15 14:26
 * Description abc的全排序；
 * 输入 abc
 */
public class ABCTest {
    public static void AllSort(char[] chars){
        if(chars == null|| chars.length<1){
            return;
        }else {
            doit(chars,0);
        }
    }
    public static void doit(char[] chars,int begin){
        char temp;
        if (begin == chars.length-1){
            System.out.println(chars);
            System.out.println("  ");
            return;
        }else {
            for(int i = begin;i< chars.length;i++){
                temp = chars[begin];
                chars[begin] = chars[i];
                chars[i]=temp;
                doit(chars, begin+1);
                temp=chars[begin];
                chars[begin]=chars[i];
                chars[i]=temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            AllSort(chars);
        }
    }
}
