package DFS;

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
    	return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }*/
    
    /*private int depth;

    public int maxDepth(TreeNode root) {
        depth = 0;
        helper(root, 1);
        
        return depth;
    }
    
    private void helper(TreeNode node, int curtDepth) {
        if (node == null) {
            return;
        }
        
        if (curtDepth > depth) {
            depth = curtDepth;
        }
        
        helper(node.left, curtDepth + 1);
        helper(node.right, curtDepth + 1);
    }*/
}
