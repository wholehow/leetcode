package hash_table;

/* 寻找所有小于n的质数。
 * */

public class Solution204 {
	
	/* 我们知道最简单的质数就是2，3，5。。。那怎么计算往后的质数呢？
	 * 这其实需要稍微转一下弯，如果n是质数，那么n的所有k倍（k>=2）一定不是质数。
	 * 只需要在每次遇到质数时，将其小于n的倍数都设为非质数，这样就避免了每次遇到一个数都要用之前所有质数去除一遍，大大降低了时间复杂度。
	 * */
	
    public int countPrimes(int n) {
        int res = 0;
        boolean[] notPrime  = new boolean[n];
        for (int i = 2; i < n; i++) {
        	if (notPrime[i] == false) {
        		res++;
        		for (int j = 2; j * i < n; j++) {
        			notPrime[j * i] = true;
        		}
        	}
        }
        return res;
    }
}
