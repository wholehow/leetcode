package BFS;

import java.util.LinkedList;
import java.util.Queue;

/* 大意：
 * 给出一个二叉树，找到他最小的深度。
 * 最小的深度是指从根节点到叶子节点距离最短的节点数。
 * */

public class Solution111 {
	
	/* 有两种思路
	 * 一是改写求二叉树的最大深度算法
	 * 二是因为这里求最小深度，如果使用求最大深度的算法相当于使用了深度优先遍历。那么我们可以利用二叉树的层次遍历，
	 * 走到某一层，如果这一层的某个结点恰好就是叶子结点，那么最小深度当然就是当前层的深度。
	 * */
	
    /*public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        } else if (root.left == null && root.right == null){
			return 1;
		}
        if (root.left == null) {
        	return minDepth(root.right) + 1;
        } else if (root.right == null) {
        	return minDepth(root.left) + 1;
        } else {
        	return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }*/
	
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int resDepth = 1;
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				if (queue.peek().left == null && queue.peek().right == null) {
					return resDepth;
				}
				if (queue.peek().left != null) {
					queue.offer(queue.peek().left);
				}
				if (queue.peek().right != null) {
					queue.offer(queue.peek().right);
				}
				queue.poll();
			}
			resDepth++;
		}
		return resDepth;
	}
}
