package string;

import java.util.Stack;

/* ���⣺
 * ����һ��ֻ���� '(', ')', '{', '}', '[' �� ']' ���ַ������ж����������Ƿ�����Ч�ġ�
 * ���ű���������ȷ��˳��رյģ� "()" �� "()[]{}" ������Ч�ģ����� "(]" �� "([)]" ����Ч�ġ�
 * */

public class Solution20 {
	
	/* ��ʵ��Ч�����Ҳ�ͼ��֣�������ƥ�䵽�˲�һ���������š������Ŷ��ˡ������Ŷ��ˡ�
	 * ��ʵ���ǿ��Գ������ջ�����ȳ������ʣ���Ϊ����ѧϰ���ݽṹʱ��ջ�Ĳ��־�ר�Ž��˱��ʽ��ֵ������ƥ�䡣
	 * */
	
    public boolean isValid(String s) {
        if (s.length() < 2) {
        	return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        		stack.push(s.charAt(i));
        	} else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') {
        		stack.pop();
        	} else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') {
        		stack.pop();
        	} else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') {
        		stack.pop();
        	} else {
        		return false;
        	}
        }
        return stack.empty();
    }
}
