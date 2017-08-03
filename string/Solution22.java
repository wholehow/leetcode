package string;

import java.awt.List;
import java.util.ArrayList;

/* 生成括号。
 * 给定n对括号，写一个函数来生成形式良好的括号的所有组合。
 * 例如：
 * 输入： n = 3
 * 输出：[
  		"((()))",
  		"(()())",
  		"(())()",
  		"()(())",
  		"()()()"
		]
 * */

public class Solution22 {
	
	/* 回溯法。
	 * 在任何时刻，我们都有两种选择：
	 * 1.加左括号
	 * 2.加右括号
	 * 在任何时刻，我们都有两种限制：
	 * 1.如果左括号已经用完了，则不能再加左括号了。
	 * 4.如果已经出现的右括号和左括号一样多，则不能再加右括号了。因为那样的话新加入的右括号一定无法匹配。
	 * */
	
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack("", res, n, n);
        return res;
        
    }
    private void backtrack(String subList, List<String> res, int left, int right) {
    	// 左右括号都已经用完
    	// 左右括号用完以后，一定是正确解。因为1. 左右括号一样多，2. 每个右括号都一定有与之配对的左括号。因此一旦结束就可以加入解集
    	if (left == 0 && right == 0) {
    		res.add(subList);
    		return;
    	}
    	// 每次都是先加左，再加右，不可能不出现left > right
    	if (left > right) {
    		return;
    	}
    	// 左还有剩余
    	if (left > 0) {
    		backtrack(subList + "(", res, left - 1, right);
    	}
    	// 右还有剩余
    	if (right > 0) {
    		backtrack(subList + ")", res, left, right - 1);
    	}
    }
}
