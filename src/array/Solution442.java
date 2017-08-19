package array;

import java.util.List;
import java.util.ArrayList;

/* 找到数组中所有重复的元素。
 * 给定整数数组，1≤a[i]≤n（n=数组大小），有些元素出现两次，其他元素出现一次。
 * 找到在这个数组中出现两次的所有元素。
 * 你可以在O(1)空间和O(N)时间情况下运行吗？
 * */

public class Solution442 {
	
	/* 感觉这个题目很有技巧性，需要从给定条件1≤a[i]≤n（n=数组大小）入手。
	 * 假设所有的位置都不重复，那么位置i出现的数就是i-1。
	 * 假设我们先把正确位置的数放好，那么出现两次的数一定是出现在它不该出现的位置。
	 * 因此我们可以利用前面整数数组判断重复取负号的思想。
	 * 如果当前位置的数小于0，说明它在前一次已经被访问并且和当前数是重复的，因此他就是一个重复的数。
	 * */
	
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
        	return resList;
        }
        for (int i = 0; i < nums.length; i++) {
        	int idx = Math.abs(nums[i]) - 1;
        	if (nums[idx] < 0) {
        		resList.add(idx + 1);
        	}
        	nums[idx] = -nums[idx];
        }
        return resList;
    }
}
