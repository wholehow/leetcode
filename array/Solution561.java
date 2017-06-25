package array;

import java.util.Arrays;

/* 大意：
 * 给定一个长度为2n的整数数组，将数组分成n组，求每组数的最小值之和的最大值。
 * 
 * 例如：
 * 输入：[1,4,3,2]
 * 输出：4
 * 其中n = 2，4 = min(1, 2) + min(3, 4)
 * */

public class Solution561 {
	
	/* 由于我们要获取的是2N大小的数组分割成N组后，每组最小数的和。
	 * 可以先使用排序对数组进行排序，每次取出每一组的较小数直接相加
	 * 即可得到返回结果，省去了比较的过程。
	 * */
	
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
