package dp;

/* 大意：
 * 给出一个整型数组 nums，寻找其中位置 i 与 j 之间元素的和，包括 i 与 j 元素。
 * 
 * 例如：
 * 给出nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * */

public class Solution303 {
	
	/* 这道题其实不是考某种算法，而是考实现的方式。
	 * 用dp[i]来存储0到i之间元素的和，0到j的和减去0到i-1的和即为所求。
	 * */
	
    private int[] dp;
    public Solution303(int[] nums) {
        dp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
