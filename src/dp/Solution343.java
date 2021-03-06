package dp;

/* 大意：
 * 给定一个正整数n，将其分解为至少两个正整数的和，并最大化这些整数的乘积。返回你可以获得的最大乘积。
 * 例如，给定n = 2，返回1（2 = 1 + 1）;给定n = 10，返回36（10 = 3 + 3 + 4）。
 * 注意：你可以假设n不小于2且不大于58。
 * */

public class Solution343 {
	
	/* 方法1：纯DP
	 * */
	
	public int integerBreak(int n) {
	    if(n < 4) return n - 1; 
	    int[] dp = new int[n + 1];
	    dp[1] = 1;
	    for(int i = 2; i <= n; i++){
	        for(int j = 2; j * 2 <= i; j++){	// j <= i/2, 因为当j>=i/2时后面就都重复了
	             // 1. 左侧无切割, 右侧最佳切割;
	             // 2. 左侧最佳切割，右侧无切割;
	             // 3. 左侧最佳切割，右侧最佳切割;
	             // 4. 左侧无切割， 右侧无切割。
	             // 四者(j * dp[i-j]),(dp[j] * (i-j)),(dp[j]*dp[i-j]),(j*(i-j))中的最大值
	            int t = Math.max(j, dp[j]) * Math.max((i-j) , dp[i-j]);
	            dp[i] = Math.max(dp[i], t);
	        }
	    }
	    return dp[n];
	}
	
	/* 方法2：纯数学
	 * 当把输入的n拆分成几个相等的数时它们的积最大。
	 * 那么问题来了，拆分成几个呢？
	 * 为了方便使用导数，我们先假设我们可以把n拆分成实数。那么设每一个数为x,则一共有n/x个数。
	 * 设它们的积为f(x),则f(x)=x^(n/x)，那么怎么求f(x)最大值呢？求导数！
	 * f′(x)=(n/x2)  *  x(n/x)  * (1-lnx)
	 * 当x=e时取极大值。
	 * 而我们题目里规定x为整数，那么我们只需要取的x越靠近e越好。那么2<e<3，而且e=2.71828...，所以取3是最好的，如果取不到3就取2。
	 * */
	
    /*public int integerBreak(int n) {
        if(n < 4) return n - 1;
        int res = 1;
        while(n > 2){	//看n包含多少个3,把他们相乘,直到n<=2
            res *= 3;
            n -= 3;
        }
        // 1.n可以整除3，res就是各个3相乘
        // 2.除3余1，把其中的一个3加1变为4再相乘
        // 3.除3余2,则可直接把2与res相乘
        return res = n == 0 ? res : (n == 1 ? res / 3 * 4 : res * 2);
    }*/
}
