package math;

/* 大意：
 * 给出两个字符串形式的非负数num1和num2，返回num1和num2之和。
 * 注意：
 * 1.num1和num2的长度都小于5100。
 * 2.num1和num2都只包含数字0-9。
 * 3.num1和num2都不包含处于首位的0。 
 * 4.你不能使用任何内置的大数库或者直接将输入转化成整型。
 * */

public class Solution415 {
	
	/* 从两个字符串的最末尾开始去加，注意判断是否要进位，一位位加到两个字符串都遍历完为止，
	 * 为了速度这里要使用StringBuilder，如果直接用 + 去进行字符拼接就太慢了，注意我们每次对每位数进行加时还是用整型来计算。
	 * */
	
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
        	return num1.length() == 0 ? num2 : num1;
        }
        boolean hasUp = false;	//是否进位
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sBuilder = new StringBuilder();
        while (i >=0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + (hasUp ? 1 : 0);
            if (sum >= 10) {
                sBuilder.insert(0, Integer.toString(sum - 10));
                hasUp = true;
            } else {
                sBuilder.insert(0, Integer.toString(sum));
                hasUp = false;
            }
            i--;
            j--;
        }
        if (hasUp) {
        	sBuilder.insert(0, "1");
        }
        return sBuilder.toString();
    }
}
