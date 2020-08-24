package ZUA.ys.bishi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 41765
 * @Creater 2020/3/30 15:27
 * Description 给定一个英文字母组成的字符串，对于字符串中字母，如果前面已经出现过，字母不区分大小写，则需要将其删除，输出删除后的字符串过
 */
public class ToHeavy {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            String result = solution(str);
            System.out.println(result);
        }

        public static String solution(String str) {
            List<Character> list = new ArrayList<>();
            String result = "";
            String up = str.toUpperCase();
            String lower = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                // 大小写问题
                if (!(list.contains(up.charAt(i)) || list.contains(lower.charAt(i)))) {
                    list.add(str.charAt(i));
                }
            }
            //链表转换成字符串，并进行拼接
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
            }
            result = sb.toString();
            return result;
        }
}
