package BFS;

import java.util.LinkedList;
import java.util.Queue;

/* ���⣺
 * ����һ�����������ҵ�����С����ȡ�
 * ��С�������ָ�Ӹ��ڵ㵽Ҷ�ӽڵ������̵Ľڵ�����
 * */

public class Solution111 {
	
	/* ������˼·
	 * һ�Ǹ�д����������������㷨
	 * ������Ϊ��������С��ȣ����ʹ���������ȵ��㷨�൱��ʹ����������ȱ�������ô���ǿ������ö������Ĳ�α�����
	 * �ߵ�ĳһ�㣬�����һ���ĳ�����ǡ�þ���Ҷ�ӽ�㣬��ô��С��ȵ�Ȼ���ǵ�ǰ�����ȡ�
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
