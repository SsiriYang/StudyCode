package ZUA.ys.design.dynamic_programme;

/**
 * Description 动态规划的简单问题
 * 一个楼梯有 10 级台阶，你从下往上走，每跨一步只能向上迈 1 级或者 2 级台阶，请问一共有多少种走法？
 * 要想走到第十层台阶？得先走到第九层，或者第八层；
 * 假设走到第x层台阶的走法几位F(x)则：F(10) = F(9)+F(8);
 * 同理 F(9) = F（8）+F(7)
 * 推理出来一个通用公式：F(X) = F（X -1）+F(X -2)；
 * F(2) 和 F(1) 可以直观推导得出
 * @author YS
 * @date 2021/2/26 14:18
 */
public class Stairs {
    /*
    * 经典的动态规划题目，动态规划的三要素，在本题中
    * F(x-1)和F(x-2)被称为最优子结构
    * F(x) =F(x-1)+F(x-2)交状态转移方程
    * F(1) = 1,F(2) = 2;是问题边界
    * */

    static int gateWays(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return gateWays(n-1) +gateWays(n-2);
    }

    static int gateWays2(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for(int i =3; i<=n; i++){
            temp =a+b;
            a = b;
            b = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        //System.out.println(gateWays(30));
        System.out.println(gateWays2(40));
    }
}
