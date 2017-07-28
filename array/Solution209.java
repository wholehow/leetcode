package array;

/* 大意：
 * 最小尺寸子数组的和
 * 给定n个正整数和一个正整数的数组，找到总和≥s的连续子阵列的最小长度。如果没有，返回0。
 * 例如：
 * 输入：[2,3,1,2,4,3],s = 7
 * 输出：[4,3]
 * */

public class Solution209 {
	
	/* 最后输出的结果是子数组，我们需要记录其边界，因此使用双指针法求解。
	 * i和j作为我们需要使用的双指针。
	 * i移动的条件是当前和大于s，j移动的条件的当前和小于s。
	 * */
	
    public int minSubArrayLen(int s, int[] nums) {
    	if (s < 0 || nums == null) {
    		return 0;
    	}
    	int i = 0, j = 0, sum = 0, minLen = Integer.MAX_VALUE;
    	// 右边界作为判断循环结束的条件
    	while (j < nums.length) {
    		sum += nums[j++];
    		// 一旦出现sum>=s，说明当前左边界已经不满足了
    		while (sum >= s) {
    			minLen = Math.min(minLen, j - i);
    			sum -= nums[i++];
    		}
    	}
    	return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
