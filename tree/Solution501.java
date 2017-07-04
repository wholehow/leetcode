package tree;

/* 求BST的众数。
 * */

public class Solution501 {
	
	/* 这里定义的BST
	 * left <= mid <= right
	 * 所以不是严格的不等关系，注意区分题目。
	 * 当然没有等于存在这道题目是不可能成立的的因为众数根本不存在哈哈。
	 * 题目要求O(1)的空间复杂度，所以我们需要先得到有多少个modes，再申请空间。
	 * 所产生的stack space不计入空间复杂度，因此可用递归。
	 * */
	
	private int cntModes = 0;	//modes计数器
	private int curValue = 0;	//候选modes的值
	private int curCount = 0;	//候选modes计数器
	private int[] modes;
	private int maxCount;		//用于判断是否可以成为真正的modes
	
    public int[] findMode(TreeNode root) {
        countModes(root);	//题目要求O(1)的空间复杂度，所以我们需要先得到有多少个modes，再申请空间。
        modes = new int[cntModes];
        curCount = 0;
        cntModes = 0;
        countModes(root);
        return modes;
    }
    private void countModes(TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	countModes(node.left);
    	if (node.val != curValue) {
    		curCount = 1;
    		curValue = node.val;
    	} else {
    		curCount++;
    	}
    	if (curCount > maxCount) {
    		maxCount = curCount;
    		curCount = 1;
    	} else if (curCount == maxCount) {
    		if (modes != null) {
    			modes[cntModes] = node.val;
    		}
    		cntModes++;
    	}
    	countModes(node.right);
    }
}
