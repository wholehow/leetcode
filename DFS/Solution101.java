package DFS;

/* 判断一棵树是否是自己的镜像。
 *  1
   / \
  2   2
 / \ / \
3  4 4  3 是镜像树
 *  1
   / \
  2   2
   \   \
   3    3 不是镜像树
 * */

public class Solution101 {

	/* 其实就是判断一个树（如果后序序列化）是否是回文。所以当然可以先将树转换为字符串，用字符串的回文算法进行检查，
	 * 但是这样做感觉就违背这道题目的初衷了。
	 * 题目说如果可以用递归和迭代来做会加分，考虑树的递归定义，其实代码还是很好写的。
	 * 先检查root的左右子节点是不是null，然后用递归去做，
	 * 每次检查一个节点的左子节点的左子节点和右子节点的右子节点以及左子节点的右子节点和右子节点的左子节点是不是一样的，就可以判断了。
	 * 听起来好绕T-T。
	 * */
	
    public boolean isSymmetric(TreeNode root) {
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
    }
}
