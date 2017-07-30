package array;

/* 延续62。
 * 现在考虑如果网格中添加了一些障碍。有多少独特的路径呢？障碍物和空格分别在网格中标记为1和0。
 * 例如：
 * [
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
 * 唯一路径的总数为2。
 * */

public class Solution63 {
	
	/* 延续62题的解法，就是在构建dp数组的时候需要根据当前位置的值是0还是1判断下一步构造过程。
	 * 首先左上角一定是1，否则题目根本没有必要做下去了。
	 * 然后初始化第一行/第一列，根据当前位置的值更新为0或者1。
	 * 之后对于每一个其他位置0或者1有序更新。最终结果还是保存在右下角。
	 * */
	
	/* 非压缩
	 * */
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length, n = obstacleGrid[0].length;
    	int[][] dp = new int[m][n];
    	dp[0][0] = obstacleGrid[0][0] ^ 1;
    	// 初始化第一行
    	for (int i = 1; i < m; i++) {
    		dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
    	}
    	// 初始化第一列
    	for (int j = 1; j < n; j++) {
    		dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
    	}
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			// 根据当前obstacleGrid位置是否为1判断dp[i][j]如何更新
    			dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i -1][j] + dp[i][j - 1];
    		}
    	}
    	return dp[m - 1][n - 1];
    }
    
    /* 压缩
     * */
    
    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }*/
}
