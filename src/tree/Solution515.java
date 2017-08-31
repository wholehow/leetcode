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
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode x = root;
        if (null != x) q.offer(x);
        
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int sz = q.size();
            for (int i = 0; i < sz; ++i) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (null != node.left)  q.offer(node.left);
                if (null != node.right) q.offer(node.right);
            }
            res.add(max);
        }
        
        return res;
    }
}
