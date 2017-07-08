package math;

/* 大意:
 * 给出一个整数，写一个函数来判断它是否是3的次方数。
 * 进阶： 你能不能不用循环和递归来做？
 * */

public class Solution326 {
    public boolean isPowerOfThree(int n) {
        return (n > 0 && (Math.log10(n) / Math.log10(3)) % 1 == 0);
    }
}
