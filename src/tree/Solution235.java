package tree;

/* 大意：
 * 给出一个二叉查找树（BST），在其中找到给出的两个节点的最低的共同祖先（LCA）。
 * 根据维基百科对LCA的定义：“最低共同祖先是指两个节点v和w在T中有v和w作为后代节点的最低节点（我们允许节点是自己的祖先）。”
 * */

public class Solution235 {
	
	/* 假设cur代表当前遍历到的结点。假设cur处理左子树时返回left，处理右子树时返回right。
	 * 1.如果发现cur = null || cur == p || cur == q，则返回cur。
	 * 2.如果left和right都为空，说明cur整棵子树上都没有找到p或q，返回null。
	 * 3.如果left和right都不为 空，说明left上一定发现了p或q，右子树上一定发现了q或p，返回cur。
	 * 4.如果left和right一个为空，另一个不为空。假设不为空的为node。node到底是什么？node要么是p或q，要么node已经是LCA，
	 * 返回node。
	 * */
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
        	return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
			return root;
		}
        return left != null ? left : right;
    }
    
    /* 上面的方法是适用于所有的二叉树，当然这里是BST，根据val有更简单的额方法。
     * 我们根据目标节点的值和根节点的值来判断目标节点在跟节点的左子树上还是右子树上，
     * 如果一个在左一个在右，就说明其LCA是根节点；
     * 如果都在左或者都在右，就对跟节点的左或者右子节点调用同样的方法进行递归。
     * */
    
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val - p.val > 0 && root.val - q.val > 0) return lowestCommonAncestor(root.left, p, q);
        else if (root.val - p.val < 0 && root.val - q.val < 0) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }*/
}	
