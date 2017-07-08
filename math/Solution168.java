package math;

/* 大意：
 * 给出一个正整数，返回它对应的Excel表格中的列标题。
 * 例子：
 * 例子：
	1 -> A 
	2 -> B 
	3 -> C ... 
	26 -> Z 
	27 -> AA 
	28 -> AB
 * */

public class Solution168 {
	
	/* 一位一位的求，从低位往高位求，每进一位，则把原数缩小26倍，再对26取余，
	 * 之后减去余数，再缩小26倍，以此类推，可以求出各个位置上的字母。
	 * 其实可以理解为将一个十进制的数字转换成一个26进制的数字，跟转换成二进制是一个道理。
	 * */
	
    public String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
            n--;	//如果是对应的Z，其实除以26是没有余数的，因此在每次取余之前，都要将n减一。
            res = String.valueOf((char)(n % 26 + 'A')) + res;	//灵活运用“+”对于字符串的操作
            n = n / 26;
        }
        return res;
    }
}
