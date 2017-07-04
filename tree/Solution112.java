package tree;

/* 大意：
 * 给出一个二叉树和一个值，判断树是否有从根节点到叶子节点的路径让每个节点的值加起来等于给出的值。
 * 例子： 给出下面的二叉树以及 sum = 22，
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * 返回true，因为存在根节点到叶子节点的路径 5->4->11->2 加起来的和为22。
 * */

public class Solution112 {

	/* 因为只需要判断有没有路径满足，也就是说只需要找到一条即可，那么采用深度优先遍历比较好，用递归来实现。
	 * 每次判断当前路径的累加和是否等于目标值了，如果等于，因为题目要求从根节点到叶子节点，
	 * 所以还要判断是否已经到叶子节点了，这个对有无左右子节点判断就可以了。
	 * 如果还不等于，那么就继续判断走左子节点或者走右子节点有没有等于。
	 * */
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
        	return false;
        } else if (root.left == null && root.right == null && root.val == sum) {
        	return true;
        } else {	//其实这里使用sum - root.val感觉效果更好
        	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
