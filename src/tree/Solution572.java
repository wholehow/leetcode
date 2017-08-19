package tree;

/* ���⣺
 * �������÷ǿն�����s��t���ж�t�Ƿ���s��������
 * */

public class Solution572 {
	
	/* ���s��t�ĸ��ڵ���ͬ�����ͷƥ�䣻
	 * ����ƥ��s����������t��s����������t��
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
    
    /* ���������ñ���+���Ӵ�
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
