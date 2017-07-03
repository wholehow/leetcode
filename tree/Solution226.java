package tree;

/* 反转二叉树
 * */
public class Solution226 {
	
	/* 对于二叉树的每个子节点的左右节点都要反转，
	 * 我们还是用递归，对每个节点都调用函数，这样就都可以反转了。
	 * 就同置换变量的数字一样，我们可以创建两个新的节点对象，然后分别等同于其左右子节点，然后将其左节点变成其右节点的新对象，
	 * 将其右节点变成其左节点的新对象，就可以了。
	 * 同时我们对每个子节点都要进行同样的操作。
	 * 还有一点很重要不要忘记了，我们一开始要先判断此节点是否为null，不为null才进行操作。
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
