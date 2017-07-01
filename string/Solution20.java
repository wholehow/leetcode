package string;

import java.util.Stack;

/* 大意：
 * 给出一个只包含 '(', ')', '{', '}', '[' 和 ']' 的字符串，判断它的输入是否是有效的。
 * 括号必须是以正确的顺序关闭的， "()" 和 "()[]{}" 都是有效的，但是 "(]" 和 "([)]" 是无效的。
 * */

public class Solution20 {
	
	/* 其实无效的情况也就几种，左括号匹配到了不一样的右括号、左括号多了、右括号多了。
	 * 其实我们可以充分利用栈后入先出的性质，因为最先学习数据结构时，栈的部分就专门讲了表达式求值和括号匹配。
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
