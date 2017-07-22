package bit_manipulation;

/* 大意：
 * 给定一个正整数，输出其补数。补充策略就是按二进制位反转。
 * 注意：
 * 1.给定正数确保是32位带符号整数。
 * 2.可以假设整数的二进制表示不包含前导0。
 * 
 * 例如：
 * 输入5，输出2。5的二进制表示为101（无前导零位），其补码为010。所以需要输出2。
 * 输入1，输出0。1的二进制表示为1（无前导零位），其补码为0。因此需要输出0。
 * */

public class Solution476 {
	
	/* 利用java里的方法Integer.highestOneBit，获得数字num出现1的最高位（也就是对应的2进制里，第一个出现1的位为1，其他为0的值） 
	 * 将上面的值左移1位，然后减1，就可以构造一个正好覆盖num整个数x位长度的遮罩mask（后x位为1，其他为0） 
	 * 使用如上mask，将num的部分进行取反就可以
	 * */
	
    public int findComplement(int num) {
    	int mask = (Integer.highestOneBit(num) << 1) - 1;	// 常用技巧
    	num = ~num;
    	return num & mask;
    }
}
