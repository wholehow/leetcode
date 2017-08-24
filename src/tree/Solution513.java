package tree;

import java.util.LinkedList;
import java.util.Queue;

/* ����һ��BST���ҵ��������һ�е�����ߵ�ֵ��
 * */

public class Solution513 {
	
	/* ��������ʹ��BFS��ζ�����ǿ��Լ򵥵ط������һ���ڵ��ֵ�������ظ��ٵ�ǰ���еĵ�һ���ڵ㣬���������������С�
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
	
	/* �ݹ鷨����res[0]��������res[1]��¼��ǰ�ݹ鵽��������
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
