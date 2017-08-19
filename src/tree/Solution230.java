package tree;

import java.util.Stack;

/* 大意：
 * 给定一棵BST，写一个函数kthSmallest来查找其中第k小的元素。
 * 如果BST被修改（插入/删除操作）经常需要找到第k个最小的元素？如何优化kthSmallest方法？
 * */

public class Solution230 {
	
	/* 方法1。利用栈后进先出的性质。
	 * 进栈的时候不作判断，只有出栈时候判断如果count=k，说明当前出战的这个node其val就是我们在查找的val。
	 * */
	
	 /*public int kthSmallest(TreeNode root, int k) {
	     Stack<TreeNode> stack = new Stack<TreeNode>();
	     int count = 0;
	     
	     while(!stack.isEmpty() || root != null) {
	         if(root != null) {
	             stack.push(root);  // Just like recursion
	             root = root.left;   
	             
	         } else {
	            TreeNode node = stack.pop();
	            if(++count == k) return node.val; 
	            root = node.right;
	         }
	     }
	     // 不存在这样的node
	     return Integer.MIN_VALUE;
	 }*/
	 
	 /* 方法2。递归
	  * 我们递归地计算左子树和右子树的节点数。假设第k个最小元素在右子树中，那么我们需要将k更新为k - leftCount - 1
	  * （leftCount + 1是左子树的节点数加上根节点）。只有当k等于leftCount + 1时，才能找到目标。
	  * */
	
	private int ans;
	public int kthSmallest(TreeNode root, int k) {
	    helper(root, k);
	    return ans;
	}

	private int helper(TreeNode root, int k) {
	    if (root == null) {
	        return 0;
	    }
	    int leftCount = helper(root.left, k);
	    int rightCount = helper(root.right, k - leftCount - 1);
	    if (k == leftCount + 1) {
	        ans = root.val;
	    }
	    return leftCount + rightCount + 1;
	}
}
