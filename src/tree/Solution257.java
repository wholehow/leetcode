package tree;

import java.util.List;
import java.util.ArrayList;

/* 大意：
 * 给定一棵二叉树，返回所有根到叶子的路径。
 * 
 * 例如：
 * 输入：
 * 1
  /   \
 2     3
  \
   5
 * 输出：["1->2->5", "1->3"]
 * */
public class Solution257 {
	
	/* 用递归，依次判断有没有左右叶子节点，分别去做递归，在递归中把遇到的节点值拼接到路径字符串的最后，注意要拼接“->”这个内容。
	 * 直到没有左右子节点后，表示已经到了叶子节点了，就可以终止了，把这条路径的字符串添加到结果中去。
	 * */
    private List<String> resList = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
        	findPaths(root, String.valueOf(root.val));
        }
        return resList;
    }
    
    private void findPaths(TreeNode node, String path){
        if (node.left == null && node.right == null) {
        	resList.add(path);
        }
        if (node.left != null) {
        	findPaths(node.left, path + "->" + node.left.val);
        }
        if (node.right != null) {
        	findPaths(node.right, path + "->" + node.right.val);
        }
    }
}
