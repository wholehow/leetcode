package tree;

import java.util.Stack;

/* ���⣺
 * ����һ��BST��дһ������kthSmallest���������е�kС��Ԫ�ء�
 * ���BST���޸ģ�����/ɾ��������������Ҫ�ҵ���k����С��Ԫ�أ�����Ż�kthSmallest������
 * */

public class Solution230 {
	
	/* ����1������ջ����ȳ������ʡ�
	 * ��ջ��ʱ�����жϣ�ֻ�г�ջʱ���ж����count=k��˵����ǰ��ս�����node��val���������ڲ��ҵ�val��
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
	     // ������������node
	     return Integer.MIN_VALUE;
	 }*/
	 
	 /* ����2���ݹ�
	  * ���ǵݹ�ؼ������������������Ľڵ����������k����СԪ�����������У���ô������Ҫ��k����Ϊk - leftCount - 1
	  * ��leftCount + 1���������Ľڵ������ϸ��ڵ㣩��ֻ�е�k����leftCount + 1ʱ�������ҵ�Ŀ�ꡣ
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
