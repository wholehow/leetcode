package math;

import java.util.HashSet;

/* 大意：
 * 写一个算法来判断一个数字是否“happy”。 一个happy数字是通过下面的过程来判别的：
 * 从一个正整数开始，用其各位数字的平方和来代替它，然后重复这个过程直到数字等于1（此时就保持不变了），
 * 或者它会一直循环而不等于1。那些得到1的数字就是happy的数字。
 * 
 * 举例：19是一个happy数字 
   1^2 + 9^2 = 82 
   8^2 + 2^2 = 68 
   6^2 + 8^2 = 100 
   1^2 + 0^2 + 0^2 = 1 
 * */

public class Solution202 {
	
	/* 对这个数字的每个数位求平方和，如果如和为1或者平方和是之前出现过的就不进行求和，根据最后的结果判断是不是一个开心数字。
	 * */
	
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        // 用于保存中间出现的结果
        HashSet<Integer> set = new HashSet<Integer>(32);
        int tmp;
        int newN;
        // n不为1，并且n的值不能重复出现，否则会死循环
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            newN = 0;
            //可以以19举例
            while (n > 0) {
                tmp = n % 10;
                n /= 10;
                newN += tmp * tmp;
            }
            n = newN;
        }
        return n == 1;
    }
}
