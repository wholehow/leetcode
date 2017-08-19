package tree;

import java.util.ArrayList;
import java.util.List;

/* 题意同96，但是需要返回所有BST的结构。
 * */

public class Solution95 {
	
	/* 首先注意到1..n是节点1到n的任何BST的按顺序遍历。 所以如果选择第i个节点作为根，左子树将包含元素1到（i-1），
	 * 右子树将包含元素（i + 1）到n。 使用递归调用来获取左右子树的所有可能的树，并以所有可能的方式将其与根结合起来。
	 * 感觉这不是DP问题，而应该是分治。
	 * */
	
	public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
	    return genTreeList(1,n);
	}

	private List<TreeNode> genTreeList(int start, int end) {
	    List<TreeNode> list = new ArrayList<TreeNode>(); 
	    if (start > end) {
	        list.add(null);
	    }
	    for (int idx = start; idx <= end; idx++) {
	        List<TreeNode> leftList = genTreeList(start, idx - 1);
	        List<TreeNode> rightList = genTreeList(idx + 1, end);
	        for (TreeNode left : leftList) {
	            for(TreeNode right: rightList) {
	                TreeNode root = new TreeNode(idx);
	                root.left = left;
	                root.right = right;
	                list.add(root);
	            }
	        }
	    }
	    return list;
	}
}
