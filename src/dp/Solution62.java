package dp;

/* 大意：
 * 机器人位于m x n网格的左上角。机器人只能在任何时间点向下或向右移动。机器人正在尝试到达网格的右下角。
 * 存在多少可能的唯一路径？
 * */

public class Solution62 {
	
	/* 简单的DP问题。
	 * 机器人只能向右或向下。每一次的选择不同，只要可以从右上角到达左下角，就是一条满足要求的路径。因此
	 * 右下角dp[m - 1][n - 1]就是所有不同的路径数量。
	 * */
	
	/* 非压缩空间
	 * */
	
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
        	return 0;
        }
        int[][] dp = new int[m][n];
        // 初始化第一列
        for (int i = 0; i < m; i++) {
        	dp[i][0] = 1;
        }
        // 初始化第一行
        for (int j = 0; j < n; j++) {
        	dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		dp[i][j] = dp[i -1][j] + dp[i][j - 1];	// 上一次位置向下或向右
        	}
        }
        return dp[m - 1][n - 1];
    }
    
    /* 压缩空间
     * */
    
    /*public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }*/
}
