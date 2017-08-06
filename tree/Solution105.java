package tree;

import java.util.HashMap;

/* 利用前序和中序遍历还原二叉树。
 * */

public class Solution105 {
	
	/* 类似105。主要搞清楚不变的下标以及下标何时变化。
	 * */
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
        	return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 建立中序遍历和索引的对应关系
        for (int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        return preIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode preIn(int[]pre, int pi, int pj, int[] in, int ni, int nj, HashMap<Integer, Integer> map) {
    	if (pi > pj) {
    		return null;
    	}
    	// 根结点即为前序遍历第一个结点
    	TreeNode root = new TreeNode(pre[pi]);
    	// 从中序遍历中找到当前根结点的索引，进行左右子树划分
    	int index = map.get(pre[pi]);
    	// 这里索引边还比较复杂，建议先找不变的边界值
    	root.left = preIn(pre, pi + 1, pi + index - ni, in, ni, index - 1, map);
    	root.right = preIn(pre, pi + index - ni + 1, pj, in, index + 1, nj, map);
    	return root;
    }
}
