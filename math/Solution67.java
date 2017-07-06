package math;

/* 二进制数加法。
 * 例如： a = "11" b = "1" 返回 "100".
 * */

public class Solution67 {
	
	/* 如果某一位两个数都是0，结果的这一位也为0，有一个1就是1，
	 * 如果都是1，这一位是0，还有进一位，所以上面三种情况还要考虑低位有没有进位。
	 * 因为两个二进制数的长度可能不同，所以我们先要在一个循环中去加两个数的和，当任一个数处理完之后，再看剩下哪个，将其加到结果中去。
	 * */
	
	public String addBinary(String a, String b) {
        int flag = 0;
        char[] res = new char[a.length() > b.length() ? a.length() : b.length()]; 
        int k = res.length - 1;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--, k--) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                res[k] = flag == 1 ?  '1' : '0';
                flag = 1;
            } else if (a.charAt(i) == '1' || b.charAt(j) == '1') {
                res[k] = flag == 1 ? '0' : '1';
                flag = flag == 1 ? 1 : 0;
            } else {
                res[k] = flag == 1 ? '1' : '0';
                flag = 0;
            }
        }
        if (i >= 0) {
            for (; i >=0; i--, k--) {
                if (a.charAt(i) == '1' && flag == 1) {
                    res[k] = '0';
                    flag = 1;
                } else if (a.charAt(i) == '1' || flag == 1) {
                    res[k] = '1';
                    flag = 0;
                } else {
                    res[k] = '0';
                    flag = 0;
                }
            }
        }
        if (j >= 0) {
            for (; j >=0; j--, k--) {
                if (b.charAt(j) == '1' && flag == 1) {
                    res[k] = '0';
                    flag = 1;
                } else if (b.charAt(j) == '1' || flag == 1) {
                    res[k] = '1';
                    flag = 0;
                } else {
                    res[k] = '0';
                    flag = 0;
                }
            }
        }
        return flag == 1 ? "1" + String.valueOf(res) : String.valueOf(res);
    }
}
