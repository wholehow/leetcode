package bit_manipulation;

/* 大意:
 * 给出一个数字（有符号32位），写一个函数来检查它是不是4的次方数。
 * 例子： 给出 num = 16，返回true。给出 num = 15，返回false。
 * 进阶：你能不能不用循环或者递归来解决它。
 * */

public class Solution342 {
	
	/* 4的二进制为100，16的二进制为10000。
	 * 最高位为1，其余都是0。
	 * */
	
    public boolean isPowerOfFour(int num) {
        if (num < 0) {
        	return false;
        }
        String binaryStr = Integer.toBinaryString(num);
        if (binaryStr.length() % 2 != 1) {
        	return false;
        }
        for (int i = 0; i < binaryStr.length(); i++) {
        	if (i == 0 && binaryStr.charAt(i) != '1') {
        		return false;
        	}
        	if (i > 0 && binaryStr.charAt(i) != '0') {
        		return false;
        	}
        }
        return true;
    }
    
    /*利用对数*/
    /*public boolean isPowerOfFour(int num) {
        return (num > 0 && (Math.log10(num) / Math.log10(4)) % 1 == 0);
    }*/
}
