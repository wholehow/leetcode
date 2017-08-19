package math;

import java.util.Arrays;

/* 大意：
 * 给定整数数组，计算其中三个数字相乘的最大值。
 * 
 * 例1：
 * 输入：[1,2,3]
 * 输出：6
 * 
 * 例2：
 * 输入：[1,2,3,4]
 * 输出：24
 * */

public class Solution628 {
	
	/* 最先想到的思路是扫描，记录到每一个位置的时候当前能得到的最大乘积。虽然这种方法很简单但是写起来比较复杂，
	 * 因为要维护的变量太多（考虑到正负数）起码要6个。
	 * 更好的思路是先排序。
	 * 如果A整体为正，最大的乘积一定是后三个数的乘积；
	 * 如果A整体为负，最大的乘积一定是前三个数的乘积；
	 * 如果A正负不定，最大的乘积一定是后两个数与第一个数的乘积或者是前两个数与后一个数的乘积。
	 * */
	
    public int maximumProduct(int[] nums) {
    	int len = nums.length;
    	Arrays.sort(nums);
    	int max1 = nums[0] * nums[1] * nums[2];
    	if (len == 3) {
			return max1;
		}
    	int max2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
    	int max3 = nums[0] * nums[1] * nums[len - 1];
    	int max4 = nums[0] * nums[len - 1] * nums[len - 2];
    	return Math.max(max1, Math.max(max2, Math.max(max3, max4)));
    }
}
