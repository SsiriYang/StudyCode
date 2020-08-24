package ZUA.ys.program;

/**
 * @Author 41765
 * @Creater 2020/2/20 14:57
 * Description
 * 	使用二分查找法找字符串数组{"a","b","c","d","e","f","g","h"}中"g"元素
 */
public class BinarySearch {
    static int bsearch( String[] a, String v ) {
        int l, r;
        l = 0;
        r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m].compareTo(v) == 0) {
                return m;
            } else if (a[m].compareTo(v) > 0) {
                r = m - 1;
            } else if (a[m].compareTo(v) < 0) {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str[] = {"a","b","c","d","e","f","g","h"};
        int bsearch = bsearch(str, "g");
        System.out.println(bsearch);
    }
}
