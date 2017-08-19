package tree;

/* 大意：
 * 给定二叉树，计算二叉树的“倾斜值”（tilt）。
 * 二叉树节点的倾斜值是指其左右子树和的差的绝对值。空节点的倾斜值为0。
 * 
 * 例如：
 * 输入：      1
       /   \
      2     3
 * 输出：1
 * Tilt of node 2 : 0
   Tilt of node 3 : 0
   Tilt of node 1 : |2-3| = 1
   Tilt of binary tree : 0 + 0 + 1 = 1
 * */

public class Solution563 {
	
	/* 递归+子树求和
	 * */
	private int tilt = 0;
    public int findTilt(TreeNode root) {
    	getTiltBypostOrder(root);
    	return tilt;
    }
    private int getTiltBypostOrder(TreeNode node) {
    	if (node == null) {
			return 0;
		}
    	int lSum = getTiltBypostOrder(node.left);
    	int rSum = getTiltBypostOrder(node.right);
    	tilt += Math.abs(lSum - rSum);
    	return lSum + rSum + node.val;
    }
}
