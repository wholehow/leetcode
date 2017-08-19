package greedy;

/* 给定一个非负整数数组。数组中的每个元素代表你在该位置的最大跳跃距离。确定你是否能够达到最后一个索引。
 * 例如：
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * */

public class Solution55 {
	
	/* 时间复杂度O(N)，空间复杂度O(1)。
	 * */
	
	public boolean canJump(int[] nums) {
	    int maxReach = 0;	// 最远能到达的位置
	    for (int i = 0; i <= maxReach; i++) {	// 如果中途已经知道我们可以到达最后，那么就不用扫描整个数组
	        maxReach = Math.max(maxReach, i + nums[i]);
	        if (maxReach >= nums.length - 1) {
	            return true;
	        }
	    }
	    return false;
	}
}
