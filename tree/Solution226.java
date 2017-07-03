package tree;

/* ��ת������
 * */
public class Solution226 {
	
	/* ���ڶ�������ÿ���ӽڵ�����ҽڵ㶼Ҫ��ת��
	 * ���ǻ����õݹ飬��ÿ���ڵ㶼���ú����������Ͷ����Է�ת�ˡ�
	 * ��ͬ�û�����������һ�������ǿ��Դ��������µĽڵ����Ȼ��ֱ��ͬ���������ӽڵ㣬Ȼ������ڵ������ҽڵ���¶���
	 * �����ҽڵ�������ڵ���¶��󣬾Ϳ����ˡ�
	 * ͬʱ���Ƕ�ÿ���ӽڵ㶼Ҫ����ͬ���Ĳ�����
	 * ����һ�����Ҫ��Ҫ�����ˣ�����һ��ʼҪ���жϴ˽ڵ��Ƿ�Ϊnull����Ϊnull�Ž��в�����
	 * */
	
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode leftNode = invertTree(root.left);
            TreeNode rightNode = invertTree(root.right);
            root.left = rightNode;
            root.right = leftNode;
            return root;
        }
    }
}
