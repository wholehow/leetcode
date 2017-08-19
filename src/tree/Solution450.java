package tree;

/* 在BST中删除结点。
 * 时间复杂度应为O（树的高度）
 * */

public class Solution450 {
	
	/* 删除结点不难，难得是在删除结点之后必须保证将剩下的结点重新还原为一棵BST。
	 * */
	
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.left == null && root.right == null)) {
        	return null;
        }
        
        if (root.val > key) {
        	root.left = deleteNode(root.left, key);	// 递归左子树
        } else if (root.val < key) {
        	root.right = deleteNode(root.right, key);	// 递归右子树
        } else {
        	if (root.left == null) {
        		return root.right;	// 只剩一个右结点
        	} else if (root.right == null){
        		return root.left; 	// // 只剩一个左结点点
        	}
        	// 交换删除法，不用在当前结点进行左右指针变换，而只需要变化最左下结点的指针
        	TreeNode minNode = finMin(root.right);
        	root.val = minNode.val;	// 将右子树最小值与当前结点交换，以后删除的值就是最小的结点
        	root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    // BST的最左下结点一定是值最小的结点
    private TreeNode finMin(TreeNode root) {
    	while (root.left != null) {
    		root = root.left;
    	}
    	return root;
    }
}	
