package tree;

import java.util.HashMap;

/* ����ǰ������������ԭ��������
 * */

public class Solution105 {
	
	/* ����105����Ҫ������±�ı仯�Լ����仯��
	 * */
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
        	return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // ������������������Ķ�Ӧ��ϵ
        for (int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        return preIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode preIn(int[]pre, int pi, int pj, int[] in, int ni, int nj, HashMap<Integer, Integer> map) {
    	if (pi > pj) {
    		return null;
    	}
    	// ����㼴Ϊǰ�������һ�����
    	TreeNode root = new TreeNode(pre[pi]);
    	// ������������ҵ���ǰ����������������������������
    	int index = map.get(pre[pi]);
    	// ���������߻��Ƚϸ��ӣ��������Ҳ���ı߽�ֵ
    	root.left = preIn(pre, pi + 1, pi + index - ni, in, ni, index - 1, map);
    	root.right = preIn(pre, pi + index - ni + 1, pj, in, index + 1, nj, map);
    	return root;
    }
}
