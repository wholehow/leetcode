package DFS;

/* 判断两棵树是否相同。
 * */

public class Solution100 {
	
	/* 两棵树相同不仅结构相同，每个结点的值还要相同。
	 * */
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
        	return true;
        }
        if (p == null || q == null) {
        	return false;
        }
        if (p.val == q.val) {
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
