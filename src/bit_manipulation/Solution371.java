package bit_manipulation;

/* 在不适用+和-的情况下计算两个数的和。
 * */

public class Solution371 {
	
	/* 用二进制实现加法运算。
	 * 在不考虑进位的情况下，a^b就是正确结果；在只算进位的情况下，(a&b)<<1就是结果。
	 * 因此把完全不考虑进位和只考虑进位产生的值再相加就是最终的结果。
	 * */
	
    public int getSum(int a, int b) {
        int sum = a;
        while (b != 0) {
        	sum = a ^ b;
        	b = (a & b) << 1;
        	a = sum;
        }
        return sum;
    }
}
