package tree;

/* 求二叉树的深度
 * */

public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
    		return 0;
    	}
    	int lDepth = maxDepth(root.left);
    	int rDepth = maxDepth(root.right);
    	return Math.max(lDepth, rDepth) + 1;
    }
    
    /*更简单点*/
    /*public int maxDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	return Math.max(maxDepth(root.left), maxDepth(root.right) + 1;
    }*/
}
