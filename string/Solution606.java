package string;

import java.util.Stack;

import javax.swing.tree.TreeNode;

/* 大意：
 * 根据字符串重构二叉树。
 * 输入包含数字和括号，数字代表根节点，括号内的子串代表左、右孩子。
 * 注意：
 * 输入字符串只包含'(', ')，'-'和数字'0'-'9'。
 * 
 * 例如：
 * 输入：Binary tree: [1,2,3,4] 
 * 	   1
     /   \
    2     3
   /    
  4     
 * 输出："1(2(4))(3)"
 * 
 * 输入：Binary tree: [1,2,3,null,4]
 *     1
     /   \
    2     3
     \  
      4 
 * 输出： "1(2()(4))(3)"
 * */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution606 {
	
	/* 根据输出结果和输入字符串的比对，发现直接使用二叉树的先序遍历就可。
	 * 注意入栈顺序即可。
	 * */
	
	public static String tree2str(TreeNode t) {
    	StringBuilder sBuilder = new StringBuilder(); 
    	if (t == null) {
    		return "";	//leetcode好多测试用例都不让返回null
    	}
    	Stack<Object> stack = new Stack<Object>();
    	//根节点入栈
    	stack.push(t);
    	while (!stack.empty()) {
    		//栈中包含TreeNode类型的二叉树节点，也包含String类型的括号
    		Object temp = stack.pop();
    		//判断是否为TreeNode类型
    		if (temp instanceof TreeNode) {
    			TreeNode node = (TreeNode) temp;
    			sBuilder.append(node.val);
    			//如果该节点左右节点都为空，则不执行任何代码，否则，执行以下代码
    			if (node.left != null || node.right != null) {
    				if (node.right != null) {
            			stack.push(")");
            			stack.push(node.right);
            			stack.push("(");
            		}
            		if(node.left != null) {
            			stack.push(")");
            			stack.push(node.left);
            			stack.push("(");
            		} else {
            			stack.push(")");
            			stack.push("(");
            		}
    			}
    		}
    		//判断是否为String类型
    		if (temp instanceof String) {
    			//String类型直接拼接到builder
    			sBuilder.append((String) temp);
    		}
       	}
    	return sBuilder.toString();
    }
}
