package tree;

/* ����һ�ö�������������Ҷ�ӽ��ĺ͡�
 * */

public class Solution404 {
	
	/* ע���Ǽ������е���Ҷ�ӽ����������е�Ҷ�ӽ�㡣
	 * ���Թؼ�����������жϵ�ǰ����Ƿ�����Ҷ�ӽ�㣨��ʹ�ý���Ѿ���Ҷ�ӽ�㲻����������Ҷ�ӣ���
	 * �������ڵ㣬����ڵ���û���ӽڵ㣬û�У�����Ҷ�ӽڵ㣩��ֱ������ʼֵȥ�ӣ������������ڵ�ݹ顣
	 * ������ҽڵ㣬���ҽڵ����ӽڵ㣬����ҽڵ�ݹ飬���򲻹���û���ҽڵ㻹���ҽڵ�û���ӽڵ㣨����Ҷ�ӽڵ㣩��ֱ�ӿ�����0��
	 * */
	
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		return ((root.left != null && root.left.left == null && root.left.right == null) ?
				root.left.val : sumOfLeftLeaves(root.left)) + ((root.right != null &&
						(root.right.left != null || root.right.right != null)) ?
						sumOfLeftLeaves(root.right) : 0);
	}
}
