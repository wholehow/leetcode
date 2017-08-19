package tree;

/* ���⣺
 * ����һ��BST������ת��Ϊ���������ʹԭʼBST��ÿ����ֵ������Ϊԭʼ��ֵ���ϴ���BST��ԭʼ��ֵ�����м�ֵ���ܺ͡�
 * ���磺
 * ���룺
 *            5
            /   \
           2     13
 * �����
 *           18
            /   \
          20     13
 * */

public class Solution538 {
	
	/* ��������BST�����ǿ��Խ��з������������BST�Ľڵ�Ľ����ڴ˹����У����Ǽ�¼���ٵ�ĿǰΪֹ�Ѿ����������нڵ�������ܺ͡�
	 * ��ǰ����������ֵ�����ڵ�ǰ��node.val��
	 * */
	
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
        	return null;
        }
        // ����������
        convertBST(root.right);
        
        root.val += sum;
        sum = root.val;
        
        // ����������
        convertBST(root.left);
        return root;
    }
}
