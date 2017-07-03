package tree;

/* 大意：
 * 求二叉树的直径，其定义为两点之间的最长路径。
 * 
 * 例如：
 * 输入：          1
         / \
        2   3
       / \     
      4   5    
 * 输出：3，最长路径为[4,2,1,3]或[5,2,1,3].
 * */
public class Solution543 {
	
	/* 和题 Lowest Common Ancestor 分析思路特别接近。
	 * 其实输出结果就是结点1左右子树的深度之和。
	 * 那么我们只要对每一个结点求出其左右子树深度之和，与res进行比较就可以更新结果res了
	 * */
	
	private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	getDiameterByDepth(root);
    	return res;
    }
    private int getDiameterByDepth(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	int lDepth = getDiameterByDepth(node.left);
    	int rDepth = getDiameterByDepth(node.right);
    	res = Math.max(res, lDepth + rDepth);
    	return Math.max(lDepth, rDepth) + 1;
    }
}
