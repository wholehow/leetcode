package string;

import java.util.Stack;

/* ��ת�ַ��� */

public class Solution344 {
	
	/*ֱ��ʹ��reverse����*/
    /*public String reverseString(String s) {
    	return new StringBuffer(s).reverse().toString();
    }*/
	
	/*��stringת����char[] ���顣Ȼ��forѭ��������ĩβ��ʼ��ǰ���ϡ�*/
	/*public static String reverseString(String s) {
        String result = "";
        char[] ch = s.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            result += ch[i];
        }
        return result;
    }*/
	
	/*forѭ����һ�롱���ݳ��ȡ�����λ�ַ��������ɡ�*/
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
	
	/*�õݹ�*/
	/*public static String reverseString(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }*/
	
	/* ��ջ*/	
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
