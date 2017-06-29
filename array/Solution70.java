package array;

/* 大意：
 * 你在爬一个楼梯。需要n节楼梯到达顶部。 每次你可以爬一节或者两节楼梯。你总共有多少种爬到顶部的方法？
 * */
	
public class Solution70 {
	
	/* 这种问题一定要倒着思考。
	 * 用数组res[n]来保存最后的输出结果，那么res[n]是如何得出的呢？
	 * 只可能是res[n - 1]走一步或者res[n - 2]走两步，总之就是
	 * res[n] = res[n - 1] + res[n - 2]
	 * */
	
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
    
    /* 更节省空间的做法 */
    /*public int climbStairs(int n) {
        if (n < 4) return n;  
        int a = 2, b = 3, c = 5;  
        for (int i = 5; i <= n; i++)  
        {  
            a = c;  
            c = b+c;  
            b = a;  
        }  
        return c;  
    }*/
}
