package dp;

/* 大意：
 * 你是一个专业的盗贼，计划偷一条街上的马。
 * 每匹马都带着明确数量的金钱，唯一阻止你偷所有马的原因是相邻的马都连接了安全系统，如果相邻的两匹马在同一天夜里被偷走就会自动联系警察。
 * 给出一个代表每个房子的非负整数的列表，确定你今天晚上可以偷窃的最大金额，而不提醒警察。
 * */

public class Solution198 {
	
	/* 这道题的本质相当于在一列数组中取出一个或多个不相邻数，使其和最大。
	 * 我们维护一个一维数组dp，其中dp[i]表示到i位置时不相邻数能形成的最大和。
	 * 由于不能抢相邻的，所以我们可以用再前面的一个的dp值加上当前的房间值，和当前房间的前面一个dp值比较，取较大值当做当前dp值。
	 * dp[i] = Math.max(num[i - 1] + dp[i - 2], dp[i - 1])
	 * */
	
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        if (nums.length == 1) {
        	return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        	//也可以使用奇偶
        	//dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1];
        }
        return dp[nums.length];
    }
    
    /* 又因为，我们只需要dp[n]，并不需要输出整个dp数组，那么可以改下代码，降低空间复杂度。
     * */
    
    /*public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        if (nums.length == 1) {
        	return nums[0];
        }
        int last = 0;
        int now = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = last;
            last = now;
            now = Math.max(temp + nums[i], last);
        }
        return now;
    }*/
}
