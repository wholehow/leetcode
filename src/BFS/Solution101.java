package BFS;

import java.util.LinkedList;
import java.util.Queue;

/* �ж�һ�����Ƿ����Լ��ľ���
 *  1
   / \
  2   2
 / \ / \
3  4 4  3 �Ǿ�����
 *  1
   / \
  2   2
   \   \
   3    3 ���Ǿ�����
 * */

public class Solution101 {

	/* ��ʵ�����ж�һ����������������л����Ƿ��ǻ��ġ����Ե�Ȼ�����Ƚ���ת��Ϊ�ַ��������ַ����Ļ����㷨���м�飬
	 * �����������о���Υ�������Ŀ�ĳ����ˡ�
	 * ��Ŀ˵��������õݹ�͵���������ӷ֣��������ĵݹ鶨�壬��ʵ���뻹�Ǻܺ�д�ġ�
	 * �ȼ��root�������ӽڵ��ǲ���null��Ȼ���õݹ�ȥ����
	 * ÿ�μ��һ���ڵ�����ӽڵ�����ӽڵ�����ӽڵ�����ӽڵ��Լ����ӽڵ�����ӽڵ�����ӽڵ�����ӽڵ��ǲ���һ���ģ��Ϳ����ж��ˡ�
	 * ����������T-T��
	 * */
	
    /*public boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
        	return true;
        }
        if (left == null || right == null) {
        	return false;
        }
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }*/
	
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		queue.offer(root.left);
		queue.offer(root.right);
		TreeNode leftNode = null, rightNode = null;
		while (queue.size() > 1) {
			leftNode = queue.poll();
			rightNode = queue.poll();
			if (leftNode == null && rightNode == null) {
				continue;
			}
			if (leftNode == null || rightNode == null) {
				return false;
			}
			if (leftNode.val != rightNode.val) {
				return false;
			}
			queue.offer(leftNode.left);
			queue.offer(rightNode.right);
			queue.offer(leftNode.right);
			queue.offer(rightNode.left);
		}
		return true;
	}
}
