package binary_search;

/* 检测完全平方数（比如16,25这种），
 * 禁止使用Math.sqrt()方法。
 * */

public class Solution367 {
	
	/* 第一种思路：既然不让使用sqrt方法，那我们可以检验i*i是否为num，一词遍历实现。
	 * */
	
    /*public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
            	return true;
            }
        }
        return false;
    }*/
	
	/* 第二种思路：使用二分查找，要查找的数为mid*mid。
	 * */
	
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = mid * mid;
            if (tmp == num) {
            	return true;
            } else if (tmp < num) {
            	left = mid + 1;
            } else {
            	right = mid - 1;
            }
        }
        return false;
    }
	
	/* 第三种思路：纯数学法
	 * 1 = 1
	 * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 + 3 + 5 + 7 + 9
     * 36 = 1 + 3 + 5 + 7 + 9 + 11
     * ...
     * 所有的完全平方数都是若干连续正奇数的和。
	 * */
	
    /*public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }*/
}
