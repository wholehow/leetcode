package math;

/* 大意:
 * 给出一个整数，写一个函数来判断它是否是3的次方数。
 * 进阶： 你能不能不用循环和递归来做？
 * */

public class Solution326 {
	
	/* 每次除3，判断最后是否为1。
	 * */
	
    /*public boolean isPowerOfThree(int n) {
        while (n > 0 && (n % 3 == 0)) {
        	n /= 3;
        }
        return n == 1;
    }*/
	
	/* n = 3^x ⇒ log3(n) = x
	 * 要判断给出的整数是不是3的立方数，只用看x是不是整数就好了。而：
	 * og3(n) = log10(n) / log10(3)
	 * */
	
    public boolean isPowerOfThree(int n) {
        return (n > 0 && (Math.log10(n) / Math.log10(3)) % 1 == 0);
    }
}
