package tree;

import java.util.LinkedList;
import java.util.Queue;

/* 大意：
 * 给你一个每个结点都包含int值的二叉树。
 * 计算能累加成指定值的路径的个数。
 * 路径不需要从根节点开始到叶子节点，但必须是往下走的（只能从父节点到子节点）。
 * 树的节点数在1000以内，并且给定的值到-1000000到1000000之间。
 * 
 * 例如：
 * 输入：
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
 * 输出：路径和为8的
 * 1.  5 -> 3
   2.  5 -> 2 -> 1
   3.  -3 -> 11
 * */

public class Solution437 {
	
	/* 这道题要从每个结点去判断往下走不断累加能不能达到要求的数字，是一个比较麻烦的过程，我们把它分解成两个过程：
	 * 1.对每个结点，都计算往下面不同分支走能不能累加成指定的值
	 * 2.从上往下去对每个结点进行上一条的判断
	 * 要记录每一个节点，我们使用队列来进行结点的记录比较方便。
	 * 而对每个节点进行路径累加和的判断，用递归比较合适，
	 * 这里要注意的是，一个结点往下走路径的过程中，并不是只要找到一条路径就可以了，而是要计算有多少条路径满足条件，
	 * 也就是说对每个结点，找完左结点即使找到了，还要找右结点，
	 * 一条路径满足后，如果对路径的最后一个结点还有子结点，那还要往下看看能不能继续累加满足，那又是一条新路径，
	 * 因为有可能下面两个结点的值互相抵消了。
	 * 所以在递归的过程中，函数返回的值不应该是能不能的布尔值，而是一个不断累加的数字，这个数字代表从一个结点往下走找到的路径数量。
	 * */
	
    public int pathSum(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int res = 0;
        if (root == null) {
        	return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
            	res += canSum(queue.peek(), sum, 0);
                if (queue.peek().left != null) {
                	queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                	queue.offer(queue.peek().right);
                }
                queue.poll();
            }
        }
        return res;
    }
    
    // 计算结点能达成条件的情况数量
    public int canSum(TreeNode root, int tgtSum, int tmpSum) {
        int sumNumber = 0;
        if (root == null) {
        	return sumNumber;
        }
        if (root.val + tmpSum == tgtSum) {
        	sumNumber++;
        }
        sumNumber += canSum(root.left, tgtSum, root.val + tmpSum) + canSum(root.right, tgtSum, root.val + tmpSum);
        return sumNumber;
    }
}
