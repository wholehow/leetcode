package array;

import java.util.Arrays;

/* 大意：
 * 给出一个int型的数组，判断数组是否包含了重复的数。
 * 如果有任何的数值在函数中出现过至少两次，就应该返回true，如果每个数值都是单一的，那么就返回false。
 * */

public class Solution217 {
	
	/* 排序好后的数组，如果有相同的数值一定出现在相邻的位置。
	 * 一次遍历完美解决 。
	 * */
	
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
