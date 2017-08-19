package string;

import java.util.Stack;

/* 反转字符串 */

public class Solution344 {
	
	/*直接使用reverse方法*/
    /*public String reverseString(String s) {
    	return new StringBuffer(s).reverse().toString();
    }*/
	
	/*将string转换成char[] 数组。然后for循环从数组末尾开始向前整合。*/
	/*public static String reverseString(String s) {
        String result = "";
        char[] ch = s.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            result += ch[i];
        }
        return result;
    }*/
	
	/*for循环”一半”数据长度。将首位字符交换即可。*/
	/*public static String reverseString(String s) {
        char[] ch = s.toCharArray();
        int halfLength = s.length() / 2;
        char temp;
        for (int i = 0; i < halfLength; i++) {
            temp = ch[s.length() - 1 - i];
            ch[s.length() - 1 - i] = ch[i];
            ch[i] = temp;
        }
        return new String(ch);
    }*/
	
	/*用递归*/
	/*public static String reverseString(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }*/
	
	/* 用栈*/	
	public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        String result = "";
        for (int i = 0; i < ch.length; i++) {
            stack.push(ch[i]);
        }
        for (int i = 0; i < ch.length; i++) {
            result += stack.pop();
        }
        return result;
    }
}
