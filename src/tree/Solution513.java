package tree;

import java.util.LinkedList;
import java.util.Queue;

/* 给定一颗BST，找到树的最后一行的最左边的值。
 * */

public class Solution513 {
	
	/* 从右向左使用BFS意味着我们可以简单地返回最后一个节点的值，而不必跟踪当前行中的第一个节点，甚至根本不关心行。
	 * */
	
/*    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
        	node = queue.poll();
        	if (node.right != null) {
        		queue.offer(node.right);
        	}
        	if (node.left != null) {
        		queue.offer(node.left);
        	}
        }
        return node.val;
    }*/
	
	/* 递归法，用res[0]保存结果，res[1]记录当前递归到的最大深度
	 * */
	
	 public int findBottomLeftValue(TreeNode root) {
		 return findBottomLeftValue(root, 1, new int[] { 0, 0 });
	 }
	 private int findBottomLeftValue(TreeNode root, int depth, int[] res) {
		 if (res[1] < depth) {
			 res[0] = root.val;
			 res[1] = depth;
		 }
		 if (root.left != null) {
			 findBottomLeftValue(root.left, depth + 1, res);
		 }
		 if (root.right != null) {
			 findBottomLeftValue(root.right, depth + 1, res);
		 }
		 return res[0];
	 }
}
