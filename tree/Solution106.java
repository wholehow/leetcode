package tree;

import java.util.HashMap;

/* ��������ͺ��������ԭ������
 * */

public class Solution106 {
	
	/* �������һ����㼴Ϊ���ڵ㡣
	 * ���������Ҫ���ȸ��ݺ������һ����㻹ԭ���ڵ㣬Ȼ�������������ʵʩ�ݹ顣
	 * Ϊʲô���������أ�ֻҪ������������ҵ����ڵ��ֵ����ô���󲿷־������������Ҳ��־�����������
	 * Ϊ���ܹ����������������л������Ҳ��֣�ʹ��Map���Դ���ʡʱ�䡣
	 * */
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
        	return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // ������������������Ķ�Ӧ��ϵ
        for (int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        return inPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode inPost(int[] in, int ni, int nj, int[] post, int ti, int tj, HashMap<Integer, Integer> map) {
        if (ti > tj) {
            return null;
        }
        // ����㼴Ϊ����������һ�����
        TreeNode root = new TreeNode(post[tj]);
        // ������������ҵ���ǰ����������������������������
        int index = map.get(post[tj]);
        // ���������߻��Ƚϸ��ӣ��������Ҳ���ı߽�ֵ
        root.left = inPost(in, ni, index - 1, post, ti, (ti - ni) + (index - 1), map);
        root.right = inPost(in, index + 1, nj, post, (ti - ni) + index, tj - 1, map);
        return root;
    }
}
