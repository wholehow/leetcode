package tree;

/* 计算一棵二叉树中所有左叶子结点的和。
 * */

public class Solution404 {
	
	/* 注意是计算所有的左叶子结点而不是所有的叶子结点。
	 * 所以关键就在于如何判断当前结点是否是左叶子结点（即使该结点已经是叶子结点不代表它是左叶子）。
	 * 如果有左节点，看左节点有没有子节点，没有（即左叶子节点）则直接用起始值去加，有则继续对左节点递归。
	 * 如果有右节点，且右节点有子节点，则对右节点递归，否则不管是没有右节点还是右节点没有子节点（即右叶子节点）都直接看做加0。
	 * */
	
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		return ((root.left != null && root.left.left == null && root.left.right == null) ? root.left.val : sumOfLeftLeaves(root.left)) 
			+ 
			((root.right != null && (root.right.left != null || root.right.right != null)) ? sumOfLeftLeaves(root.right) : 0);
	}
}
