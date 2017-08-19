package math;

/* 大意：
 * 你有n枚硬币，想要用来组成一个完整的楼梯，每一层都要有层数对应的硬币数。
 * 给出n，返回可以组成的完整楼梯的层数。
 * n是一个非负数，且满足32位int的范围。
 * 例1：
 * n = 5
 * 硬币可以组成下面的行：
 * ¤
   ¤ ¤
   ¤ ¤
 * 因为第三层是不完整的，所以我们返回2。
 * 例2：
 * n = 8
 * 硬币可以组成下面的行：
 * ¤
   ¤ ¤
   ¤ ¤ ¤
   ¤ ¤
 * 因为第四行是不完整的，所以我们返回3
 * */

public class Solution441 {
	
	/* 从第一行开始，一行一行的从n中减去，如果此时剩余的硬币没法满足下一行需要的硬币数了，直接返回当前行数即可。
	 * */
	
	 /*public int arrangeCoins(int n) {
		 int cur = 1;
		 int rem = n - 1;
		 while (rem >= cur + 1) {
			 cur++;
			 rem -= cur;
		 }
		 return n == 0 ? 0 : cur;
	 }*/
	
	/* 二分搜索法，我们搜索前i行之和刚好大于n的临界点，这样我们减一个就是能排满的行数，
	 * 注意我们计算前i行之和有可能会整型溢出，所以我们需要将变量都定义成长整型。
	 * 虽然AC，但是会运行超时。
	 * */
	
	/*public int arrangeCoins(int n) {
		if (n < 1) {
			return 0;
		}
		long low = 1;
		long high = n;
		while (low <= high) {
			long mid = (low + high) / 2;
			if (mid * (mid + 1) / 2 <= n) {
				low = mid; 
			} else {
				high = mid - 1;
			}
		}
		return (int)low - 1;
	}*/
	
	/* 一元二次方程的求根公式求解n = (1 + x) * x / 2可以得到
	 *  x = (-1 + sqrt(8 * n + 1)) / 2, 然后取整后就是能填满的行数。
	 * */
	
	public int arrangeCoins(int n) {
		return (int)((Math.sqrt(8*(long)n + 1) - 1)/2);
	}
}
