package dp;

/* ���⣺
 * ������λ��m x n��������Ͻǡ�������ֻ�����κ�ʱ������»������ƶ������������ڳ��Ե�����������½ǡ�
 * ���ڶ��ٿ��ܵ�Ψһ·����
 * */

public class Solution62 {
	
	/* �򵥵�DP���⡣
	 * ������ֻ�����һ����¡�ÿһ�ε�ѡ��ͬ��ֻҪ���Դ����Ͻǵ������½ǣ�����һ������Ҫ���·�������
	 * ���½�dp[m - 1][n - 1]�������в�ͬ��·��������
	 * */
	
	/* ��ѹ���ռ�
	 * */
	
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
        	return 0;
        }
        int[][] dp = new int[m][n];
        // ��ʼ����һ��
        for (int i = 0; i < m; i++) {
        	dp[i][0] = 1;
        }
        // ��ʼ����һ��
        for (int j = 0; j < n; j++) {
        	dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		dp[i][j] = dp[i -1][j] + dp[i][j - 1];	// ��һ��λ�����»�����
        	}
        }
        return dp[m - 1][n - 1];
    }
    
    /* ѹ���ռ�
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
