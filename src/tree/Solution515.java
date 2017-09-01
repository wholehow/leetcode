package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 寻找二叉树中每一行的最大值。
 * */

public class Solution515 {
	
	/* BFS
	 * */
	
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
        	queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (null != node.left)  
                	queue.offer(node.left);
                if (null != node.right) 
                	queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
