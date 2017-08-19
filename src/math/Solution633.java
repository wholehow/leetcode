package math;

/* 判断一个数是否是完全平方数。即c = a^2 + b^2。
 * */

public class Solution633 {
	
	/* 最简单的方法，是对于a,b（0 < a, b <= c），不断判断c = a^2 + b^2是够成立。这样的时间复杂度为O(N^2)，会超时。
	 * 由于c = a^2 + b^2，所以只需要从0到sqrt(c)遍历，求得c-i*i的剩余值，
	 * 并对其进行开方，如果开方后结果的平方等于开方前结果，则为true，
	 * 因为sqrt()函数保留整数位，所以不能开方的数结果只是整数位，乘方回去必然不等于开方前的数
	 * */
	
    public boolean judgeSquareSum(long c) {  
    	if (c == 0) {
    		return true;
    	}
        for(long i = 0; i * i <= c; i++){  
            long rem = c - i * i;  
            long r = (long)Math.sqrt(rem);  
            if (rem == r * r) {
            	return true;  
            }
        }  
        return false;  
    }  
}
