package ZUA.ys.bishi;

import org.apache.commons.lang3.StringUtils;

/**
 * Description
 *
 * @author YS
 * @date 2020/12/10 9:46
 */
public class StringSplite {
  public static void main(String[] args) {
    /*1. 截取指定位置的字符串*/

    StringUtils.substring("dskabcee", 3);
    /*结果是：abcee*/

    StringUtils.substring("dskabcee", 3, 5);
    /*结果是：ab*/

    /*2. 截取指定字符串之前的内容 */

    StringUtils.substringBefore("dskeabcee", "e");
    /*结果是：dsk*/

    StringUtils.substringBeforeLast("dskeabcee", "e");//一直找到最后一个指定的字符串
    /*结果是：dskeabce*/

    StringUtils.substringAfter("dskeabcedeh", "e");
    /*结果是：abcedeh*/

    StringUtils.substringAfterLast("dskeabcedeh", "e");
    /*结果是：h*/

    /*3. 截取参数2和参数3中间的字符*/

    StringUtils.substringBetween("dskeabcedeh", "ds");
    /*结果是：null*/
    StringUtils.substringBetween("dskeabcedeh", "ds","e");
    /*结果是：k*/
    StringUtils.substringsBetween("dskeabcedeh", "ds","e");//以数组方式返回参数2和参数3中间的字符串
    /*结果是：k */

  String a = StringUtils.substringBefore("53M\t/home/anytxnv2/anydmp/anydmp/upload-file/anydmp-develop-169.tar.gz","\t");
  System.out.println(a);
  }
}
