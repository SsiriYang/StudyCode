package ZUA.ys.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 41765
 * @Creater 2020/8/10 10:36
 * Description
 */
public class ShortChainUtils {

    private static final long MIN = 10000000000L;

    private static final long SUFFIX_ID = ((1L << 34) - 1);

    private static final long PRE_ID = (7L << 34);

    private static final long MAX_ID = 85899345919L;

    public static long next(long id) {

        if (id < 0 || id > MAX_ID) {
            throw new IllegalArgumentException("Illegal id: " + id);
        }

        // 非线性
        id = swap(id, 7, 0);
        id = swap(id, 6, 1);

        // Id后34位
        long value = id & SUFFIX_ID;

        // Id后34位的最低八位和高1-9位交换
        value = (((value >> 8) | ((value & 255) << 26)));

        // Id前3位|Id后34位
        id = (id & PRE_ID) | value;

        // 加上最小值, 保证生成的11位
        id += MIN;

        return id;
    }

    /**
     * xxxx xxxx xxxx x0xx xxxx xx0x xxxx xxxx|0000 0000 0000 0b00 0000 00a0
     * 0000 0000
     */
    private static long swap(long value, int x, int y) {

        return (value & (~(1 << x)) & (~(1 << y))) | (((value >> x) & 1) << y) | (((value >> y) & 1) << x);
    }

    private ShortChainUtils() {
    };

    public static void main(String[] args) {
        Set set = new HashSet();
        for (int i = 0; ; i++) {

            long id = ShortChainUtils.next(i);
            System.out.println(id + "---" + i);
            if (set.contains(id)) {
                System.out.println("duplicated");
                break;
            }
            set.add(id);
        }
    }
}