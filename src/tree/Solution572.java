package tree;

/* 大意：
 * 给定两棵非空二叉树s和t，判断t是否是s的子树。
 * */

public class Solution572 {
	
	/* 如果s和t的根节点相同，则从头匹配；
	 * 否则匹配s的左子树与t或s的右子树与t。
	 * */
	
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        
        if (isEqual(s, t)) {
            return true;
        }
        if (isSubtree(s.left, t) || isSubtree(s.right, t)) {
            return true;
        }
        return false;
    }
    
    private boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
    }
    
    /* 还可以利用遍历+求子串
     * */
    
    /*StringBuilder sBuilderPre = new StringBuilder();
    StringBuilder tBuilderpre = new StringBuilder();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        preOrder(s, sBuilderPre.append(","));
        preOrder(t, tBuilderpre.append(","));
        return sBuilderPre.toString().contains(tBuilderpre.toString());
    }
    private void preOrder(TreeNode root, StringBuilder sBuilder){
        if(root == null){
            sBuilder.append("#,");
            return;
        }
        sBuilder.append(root.val).append(",");
        preOrder(root.left, sBuilder);
        preOrder(root.right, sBuilder);
    }*/
}
