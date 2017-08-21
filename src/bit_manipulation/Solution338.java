package bit_manipulation;

/* 给定一个非负整数num。对于每一个满足0 ≤ i ≤ num的数字i，计算其数字的二进制表示中1的个数，并以数组形式返回。
 * 例如：
 * 输入：num = 5
 * 输出：[0,1,1,2,1,2]
 * */

public class Solution338 {
	
	/*public int[] countBits(int num) {
    	// 最后一位 ( 1 or 0, 即 " i&1 "等价于 " i%2 " )
    	// 其他位( 有效1的数目, " f[i >> 1] "等价于" f[i/2] " )
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			ans[i] = ans[i >> 1] + (i & 1);
		}
		return ans;
    }*/
	
	/* highbits(n) = 1<<int(Math.log(x,2))
	 * 其中highbits(n)表示只保留n的最高位得到的数字。
	 * 递推式：ans[n] = ans[n - highbits(n)] + 1
	 * */
	
	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			ans[i] = ans[i - (1 << (int)Math.log(i))] + 1;
		}
		return ans;
	}
}
