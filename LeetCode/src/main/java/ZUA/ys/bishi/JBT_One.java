package ZUA.ys.bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 41765
 * @Creater 2020/4/1 20:18
 * Description
 * 给定一个正整数n 求素数p使得p-n的绝对值最小；
 * 输入：n
 * 输出：与n最近的素数，如果存在多个，取较小的
 */
public class JBT_One {
    public static List<Integer> getRes(int n){
        int i,j;
        List<Integer> res = new ArrayList();
        for (i = 2; i < n; i++) {
            for (j   = 2;  j<i ; j++) {
                if(i%j==0){
                    res.add(i);
                }
            }
            if(j>=i){
                res.add(i);
            }
        }
        return res;
    }
    public static int fun(int n,List<Integer> res ){
        int min = 0;
        int temp =0;
        for (int i = 0; i <res.size() ; i++) {
            temp = Math.abs(res.get(0)-n);
            min =temp;
            if(temp<min){
                min = temp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> res = getRes(n);
        int min = fun(n,res);
        System.out.println(min);
    }
}
