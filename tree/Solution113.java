package tree;

import java.awt.List;
import java.util.ArrayList;

/* 给定一棵二叉树和一个和，找到所有根到叶的路径，其中每个路径的和等于给定的和。
 * 例如：
 * 输入：
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 * 输出：[
   		[5,4,11,2],
   		[5,8,4,5]
		]
 * */

public class Solution113 {
	
	/* 同pathSum I和pathSum II。基本都是一样的做法。有一个技巧就是每次DFS的时候我们计算sum-root.val的值，
	 * 用subList记录当前遍历的路径。如果root.val=sum且root是一个叶子结点，说明当前路径是满足条件的。
	 * */
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> resList = new ArrayList<>();
    	List<Integer> subList = new ArrayList<>();
    	// 这里sum<0竟然不能作为不合法条件，惊呆了
    	if (root == null) {
    		return resList;
    	}
    	pathSum(root, sum, resList, subList);
    	return resList;
    }
    private void pathSum(TreeNode root, int sum, List<List<Integer>> resList, List<Integer> subList){
    	if (root == null) {
    		return;
    	}
    	subList.add(new Integer(root.val));
    	if (root.left == null && root.right == null && sum == root.val) {
    		resList.add(new ArrayList<>(subList));
    		// 为什么要删除最后一个？假设第n个不满足条件，我们可以断定，前面的n-1个都是满足条件的。
    		// 此时我们只需要找到一个新的n即可。
    		subList.remove(subList.size() - 1);
    		return;
    	} else {
    		pathSum(root.left, sum - root.val, resList, subList);
    		pathSum(root.right, sum - root.val, resList, subList);
    	}
    	subList.remove(subList.size() - 1);
    }
}
