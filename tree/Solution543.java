package tree;

/* ���⣺
 * ���������ֱ�����䶨��Ϊ����֮����·����
 * 
 * ���磺
 * ���룺          1
         / \
        2   3
       / \     
      4   5    
 * �����3���·��Ϊ[4,2,1,3]��[5,2,1,3].
 * */
public class Solution543 {
	
	/* ���� Lowest Common Ancestor ����˼·�ر�ӽ���
	 * ��ʵ���������ǽ��1�������������֮��+1��
	 * ��ô����ֻҪ��ÿһ���������������������֮�ͣ��ټ���1�Ϳ��Ը��½��res��
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
