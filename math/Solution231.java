package math;

/* 大意：
 * 给出一个整数，写一个函数判断它是否是2的次方数。
 * */

public class Solution231 {
	
	/* 这道题和326题目很像，但是这个更简单，因为有一个二进制的东西存在，
	 * 我们要判断一个数是不是2的次方数，不用去一次次除以2，也不用用log去算，直接转换成二进制，
	 * 如果是2的次方数，那一定是最高位为1，其余位均为0的二进制数，所以只用判断这个二进制数是不是符合这个情况就可以了。
	 * */
	
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
        	return false;
        }
        String binaryStr = Integer.toBinaryString(n);
        for (int i = 0; i < binaryStr.length(); i++) {
            if (i == 0 && binaryStr.charAt(i) != '1') {
            	return false;
            } else if (i > 0 && binaryStr.charAt(i) != '0') {
            	return false;
            }
        }
        return true;
    }
}
