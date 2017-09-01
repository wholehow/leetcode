package array;

import java.util.Arrays;

/* 给定非空整数数组，求使得数组中的所有元素均相等的最小移动次数，一次移动是指将某个元素加1或者减1。
 * */

public class Solution462 {
	
	/* 1.由于每次都只能加1或者减1。那我们干脆点，对数组排序后，每次用数组两头的数进行差值计算，这样得出的结果一定是
	 * 需要移动的次数之和。因为不管大数，小数，早晚都要变成一个相同的数。
	 * */
	
/*    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }*/
    
    /* 2.思路同1，所有数不是两端变化，而是都向中位数去变化。
     * */
    
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0, mid = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            res += i > mid ? nums[i] - nums[mid] : nums[mid] - nums[i];
        }
        return res;
    }
}
