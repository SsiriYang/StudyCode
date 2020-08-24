package ZUA.ys.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 41765
 * Date 2020/1/13 10:39
 * Description
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice01  {
    public static int[] twoSum(int[] nums, int target) {
    int[] a=new int[2];
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]+nums[i+1]==target){
            a[0] = i;
            a[1] = i+1;
        }
    }
    return a;
}

        /**
         * @Author 41765
         * @Description //hashMap.containsKey()的时间复杂度，使用指针指向数组引用，时间复杂度为O(1)，未命中时，才回去遍历红黑树，时间复杂度为O(n)
         * @Date 14:24 2020/1/13
         * @Param 需要进行判断的数组；
         * @return 相加等于target的两个下标
         **/
        public static int[] twoSum1(int[] nums, int target) {
            int[] a = {0,1,5,3,4};
            Practice01.twoSum(a,6);
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }

}
