package array;

/* ����62��
 * ���ڿ�����������������һЩ�ϰ����ж��ٶ��ص�·���أ��ϰ���Ϳո�ֱ��������б��Ϊ1��0��
 * ���磺
 * [
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
 * Ψһ·��������Ϊ2��
 * */

public class Solution63 {
	
	/* ����62��Ľⷨ�������ڹ���dp�����ʱ����Ҫ���ݵ�ǰλ�õ�ֵ��0����1�ж���һ��������̡�
	 * �������Ͻ�һ����1��������Ŀ����û�б�Ҫ����ȥ�ˡ�
	 * Ȼ���ʼ����һ��/��һ�У����ݵ�ǰλ�õ�ֵ����Ϊ0����1��
	 * ֮�����ÿһ������λ��0����1������¡����ս�����Ǳ��������½ǡ�
	 * */
	
	/* ��ѹ��
	 * */
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length, n = obstacleGrid[0].length;
    	int[][] dp = new int[m][n];
    	dp[0][0] = obstacleGrid[0][0] ^ 1;
    	// ��ʼ����һ��
    	for (int i = 1; i < m; i++) {
    		dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
    	}
    	// ��ʼ����һ��
    	for (int j = 1; j < n; j++) {
    		dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
    	}
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			// ���ݵ�ǰobstacleGridλ���Ƿ�Ϊ1�ж�dp[i][j]��θ���
    			dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i -1][j] + dp[i][j - 1];
    		}
    	}
    	return dp[m - 1][n - 1];
    }
    
    /* ѹ��
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
