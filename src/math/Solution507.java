package math;

/* 大意：
 * 完美数，判断某正整数n是否等于除其本身外所有因子之和。
 * 注意：n不超过1e8。
 * 例如：
 * 输入：28
 * 输出：true，解释 28 = 1 + 2 + 4 + 7 + 14
 * */

public class Solution507 {
	
	/* 这题参考了别人的答案，想的不是很明白。
	 * 那么由于不能包含自身，所以n必定大于1。
	 * 由于1肯定是因子，可以提前加上，那么我们找其他因子的范围是[2, sqrt(n)]。
	 * 我们遍历这之间所有的数字，如果可以被n整除，那么我们把i和num/i都加上，
	 * 对于n如果是平方数的话，那么我们此时相同的因子加来两次，所以我们要减掉一次。
	 * 还有就是在遍历的过程中如果累积和sum大于n了，直接返回false即可。在循环结束后，我们看sum是否和num相等
	 * */
	
	 public boolean checkPerfectNumber(int num) {
		 if (num <= 1) {
			 return false;
		 }
		 int sum = 1;
		 for (int i = 2; i < Math.sqrt(num); i++) {
			 if (num % i == 0) {
				 sum += (i + num / i);
			 }
			 if (i * i == num) {
				 sum -= i;
			 }
			 if (sum > num) {
				 return false;
			 }
		 }
		 return sum == num;
	 }
}
