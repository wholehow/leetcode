package tree;

/* ���⣺
 * ����һ����������һ��ֵ���ж����Ƿ��дӸ��ڵ㵽Ҷ�ӽڵ��·����ÿ���ڵ��ֵ���������ڸ�����ֵ��
 * ���ӣ� ��������Ķ������Լ� sum = 22��
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * ����true����Ϊ���ڸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2 �������ĺ�Ϊ22��
 * */

public class Solution112 {

	/* ��Ϊֻ��Ҫ�ж���û��·�����㣬Ҳ����˵ֻ��Ҫ�ҵ�һ�����ɣ���ô����������ȱ����ȽϺã��õݹ���ʵ�֡�
	 * ÿ���жϵ�ǰ·�����ۼӺ��Ƿ����Ŀ��ֵ�ˣ�������ڣ���Ϊ��ĿҪ��Ӹ��ڵ㵽Ҷ�ӽڵ㣬
	 * ���Ի�Ҫ�ж��Ƿ��Ѿ���Ҷ�ӽڵ��ˣ���������������ӽڵ��жϾͿ����ˡ�
	 * ����������ڣ���ô�ͼ����ж������ӽڵ���������ӽڵ���û�е��ڡ�
	 * */
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
        	return false;
        } else if (root.left == null && root.right == null && root.val == sum) {
        	return true;
        } else {	//��ʵ����ʹ��sum - root.val�о�Ч������
        	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
