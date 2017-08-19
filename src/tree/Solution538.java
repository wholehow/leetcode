package tree;

/* 大意：
 * 给定一颗BST，将其转换为更大的树，使原始BST的每个键值都更改为原始键值加上大于BST中原始键值的所有键值的总和。
 * 例如：
 * 输入：
 *            5
            /   \
           2     13
 * 输出：
 *           18
            /   \
          20     13
 * */

public class Solution538 {
	
	/* 由于这是BST，我们可以进行反向遍历，遍历BST的节点的降序。在此过程中，我们记录跟踪到目前为止已经遍历的所有节点的运行总和。
	 * 以前遍历看到的值都大于当前的node.val。
	 * */
	
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
        	return null;
        }
        // 处理右子树
        convertBST(root.right);
        
        root.val += sum;
        sum = root.val;
        
        // 处理左子树
        convertBST(root.left);
        return root;
    }
}
