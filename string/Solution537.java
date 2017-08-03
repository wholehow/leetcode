package string;

/* 复数乘法
 * 给定两个表示两个复数的字符串。你需要返回一个表示它们的乘法的字符串。
 * 例如：
 * 输入："1+1i", "1+1i"
 * 输出："0+2i"
 * */

public class Solution537 {
	
	/* 很简单的题目。
	 * 写一个方法getValue用于获取有效运算数字（i不需要计算，我们只知道它是第二部分，其乘积运算何时为-1即可）。
	 * */
	
    public String complexNumberMultiply(String a, String b) {
        int[] valA = getValue(a);
        int[] valB = getValue(b);
        // 实部
        int real = valA[0] * valB[0] - valA[1] * valB[1];
        // 虚部
        int img = valA[0] * valB[1] + valA[1] * valB[0];
        return real + "+" + img + "i";
    }
    
    private int[] getValue(String str) {
    	// 注意正则表达式的书写
    	String[] strs = str.split("\\+|i");
    	int[] val = new int[2];
    	val[0] = Integer.parseInt(strs[0]);
    	val[1] = Integer.parseInt(strs[1]);
    	return val;
    }
}
