package tree;

/* ������������
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
    
    /*���򵥵�*/
    /*public int maxDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	return Math.max(maxDepth(root.left), maxDepth(root.right) + 1;
    }*/
}
