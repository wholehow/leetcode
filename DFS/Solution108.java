package DFS;

/* 大意：
 * 给定一个排序数组将其转换为BST。
 * */

public class Solution108 {
	
	/* 捋清楚BST和二分查找的关系，代码很好写。
	 * */
	
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return null;
        }
        return constructBSTBySorterArray(nums, 0, nums.length - 1);
    }
    private TreeNode constructBSTBySorterArray(int[] nums, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = constructBSTBySorterArray(nums, low, mid - 1);
		root.right = constructBSTBySorterArray(nums, mid  + 1, high);
		return root;
	}
}
