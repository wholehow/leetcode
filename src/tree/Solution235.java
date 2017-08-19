package tree;

/* ���⣺
 * ����һ�������������BST�����������ҵ������������ڵ����͵Ĺ�ͬ���ȣ�LCA����
 * ����ά���ٿƶ�LCA�Ķ��壺����͹�ͬ������ָ�����ڵ�v��w��T����v��w��Ϊ����ڵ����ͽڵ㣨��������ڵ����Լ������ȣ�����
 * */

public class Solution235 {
	
	/* ����cur����ǰ�������Ľ�㡣����cur����������ʱ����left������������ʱ����right��
	 * 1.�������cur = null || cur == p || cur == q���򷵻�cur��
	 * 2.���left��right��Ϊ�գ�˵��cur���������϶�û���ҵ�p��q������null��
	 * 3.���left��right����Ϊ �գ�˵��left��һ��������p��q����������һ��������q��p������cur��
	 * 4.���left��rightһ��Ϊ�գ���һ����Ϊ�ա����費Ϊ�յ�Ϊnode��node������ʲô��nodeҪô��p��q��Ҫônode�Ѿ���LCA��
	 * ����node��
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
    
    /* ����ķ��������������еĶ���������Ȼ������BST������val�и��򵥵Ķ����
     * ���Ǹ���Ŀ��ڵ��ֵ�͸��ڵ��ֵ���ж�Ŀ��ڵ��ڸ��ڵ���������ϻ����������ϣ�
     * ���һ������һ�����ң���˵����LCA�Ǹ��ڵ㣻
     * �����������߶����ң��ͶԸ��ڵ����������ӽڵ����ͬ���ķ������еݹ顣
     * */
    
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val - p.val > 0 && root.val - q.val > 0) return lowestCommonAncestor(root.left, p, q);
        else if (root.val - p.val < 0 && root.val - q.val < 0) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }*/
}	
