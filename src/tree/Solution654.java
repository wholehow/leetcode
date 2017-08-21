package tree;

/* 大意：
 * 给定无重复的数组。一棵最大树定义如下:
 * 1.从数组中挑选最大的数字作为根
 * 2.挑选左半数组中最大的数字作为左子树的根
 * 3.挑选右半数组中最大的数字作为右子树的根
 * 4.递归此过程。
 * */

public class Solution654 {
	
	/* 递归。用maxIdx保存当前最大索引。
	 * */
	
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return null;
        }
        return build(nums, 0, nums.length - 1);
    }
    private TreeNode  build(int[] nums, int lo, int hi) {
    	if (lo == hi) {
    		return new TreeNode(nums[lo]);
    	}
    	// max保存当前最大值，maxIdx保存最大索引
    	// 使用maxIdx可以很方便后面的操作
    	int max = Integer.MIN_VALUE, maxIdx = lo;
    	for (int i = lo; i <= hi; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
    	}
    	TreeNode root = new TreeNode(max);
    	if (maxIdx - 1 >= lo) {
    		root.left = build(nums, lo, maxIdx - 1);
    	}
    	if (maxIdx + 1 <= hi) {
    		root.right = build(nums, maxIdx + 1, hi);
    	}
    	return root;
    }
}
