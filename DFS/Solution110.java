package DFS;

/* 判断平衡二叉树
 * */

public class Solution110 {
	
	/* 递归
	 * 可以把返回值-1作为求树高的一个异常（不平衡），这样就节省了在主方法中判断的必要。
	 * */
	
    public boolean isBalanced(TreeNode root) {
    	if (getHeight(root) == -1) {
    		return false;
    	} else {
    		return true;
    	}
    }
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lH = getHeight(root.left);
		if (lH == -1) {
			return -1;
		}
		int rH = getHeight(root.right);
		if (rH == -1) {
			return -1;
		}
		if (Math.abs(lH - rH) > 1) {
			return -1;
		}
		return Math.max(lH, rH) + 1;
	}
}
