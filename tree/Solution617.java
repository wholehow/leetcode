package tree;

/* 大意：
 * 给定两棵二叉树，想象当你把其中一棵树覆盖另一棵树时，这两棵树的一些结点是重叠的，而另一些结点则不是。
 * 你需要把它们合并成一棵新的二叉树。
 * 合并规则是，如果两个结点重叠，则将结点值的和作为合并结点的新值。否则，非空节点将被用作新树的节点。
 * 合并前：
 * 	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7  
 * 合并后：  3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 * */

public class Solution617 {
	
	/* 方法有很多，关键一点是对两棵树采用相同的遍历方法才能保证最后的结果是我们需要的。
	 * 这里使用递归的方法，用二叉树前序遍历的方法，依次求出值，最后返回根节点。
	 * */
	
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
        	return null;
        }
        if (t1 == null || t2 == null) {
        	return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
