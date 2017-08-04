package tree;

import java.util.HashMap;

/* 利用中序和后序遍历还原二叉树
 * */

public class Solution106 {
	
	/* 后序最后一个结点即为根节点。
	 * 因此我们需要首先根据后序最后一个结点还原根节点，然后对其左右子树实施递归。
	 * 为什么可以这样呢？只要在中序遍历中找到根节点的值，那么其左部分就是左子树，右部分就是右子树。
	 * 为了能够方便的在中序遍历中划分左右部分，使用Map可以大大节省时间。
	 * */
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
        	return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 建立中序遍历和索引的对应关系
        for (int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        return inPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode inPost(int[] in, int ni, int nj, int[] post, int ti, int tj, HashMap<Integer, Integer> map) {
        if (ti > tj) {
            return null;
        }
        // 根结点即为后序遍历最后一个结点
        TreeNode root = new TreeNode(post[tj]);
        // 从中序遍历中找到当前根结点的索引，进行左右子树划分
        int index = map.get(post[tj]);
        // 这里索引边还比较复杂，建议先找不变的边界值
        root.left = inPost(in, ni, index - 1, post, ti, (ti - ni) + (index - 1), map);
        root.right = inPost(in, index + 1, nj, post, (ti - ni) + index, tj - 1, map);
        return root;
    }
}
