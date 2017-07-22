package bit_manipulation;

import javax.management.relation.RoleUnresolved;

/* 大意：
 * 将数字转化为16进制字符串，负数采用补码表示。不允许使用系统函数。
 * 注意：
 * 1.16进制的a-f都是小写
 * 2.十六进制字符串不能包含额外的前导0。如果数字为零，则由单个零字符'0'表示；否则，十六进制字符串中的第一个字符将不为零字符。
 * 3.给定的数字保证在32位有符号整数的范围内。
 * 4您不得使用库中提供的任何方法将数字直接转换/格式化为十六进制。
 * */

public class Solution405 {
	
	/* 我们采取位操作的思路，每次取出最右边四位，如果其大于等于10，找到对应的字母加入结果，反之则将对应的数字加入结果，然后num像右平移四位，
	 * 循环停止的条件是num为0，或者是已经循环了7次（32位）
	 * */
	
    public String toHex(int num) {
    	String rst = "";
    	int i = 0;
    	while (num != 0 && i < 8) {
    		int t = num & 0xf;	//每次取最右4位
    		if (t >= 10) {
    			rst = (char)('a' + t - 10) + rst;
    		} else {
    			rst = (char)('0' + t) + rst;
    		}
    		i++;
    		num >>= 4;
    	}
    	return rst.isEmpty() ? "0" : rst;
    }
}
