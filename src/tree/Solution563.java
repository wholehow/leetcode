package tree;

/* ���⣺
 * ����������������������ġ���бֵ����tilt����
 * �������ڵ����бֵ��ָ�����������͵Ĳ�ľ���ֵ���սڵ����бֵΪ0��
 * 
 * ���磺
 * ���룺      1
       /   \
      2     3
 * �����1
 * Tilt of node 2 : 0
   Tilt of node 3 : 0
   Tilt of node 1 : |2-3| = 1
   Tilt of binary tree : 0 + 0 + 1 = 1
 * */

public class Solution563 {
	
	/* �ݹ�+�������
	 * */
	private int tilt = 0;
    public int findTilt(TreeNode root) {
    	getTiltBypostOrder(root);
    	return tilt;
    }
    private int getTiltBypostOrder(TreeNode node) {
    	if (node == null) {
			return 0;
		}
    	int lSum = getTiltBypostOrder(node.left);
    	int rSum = getTiltBypostOrder(node.right);
    	tilt += Math.abs(lSum - rSum);
    	return lSum + rSum + node.val;
    }
}
