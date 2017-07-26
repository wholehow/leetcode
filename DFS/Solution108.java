package DFS;

/* ���⣺
 * ����һ���������齫��ת��ΪBST��
 * */

public class Solution108 {
	
	/* �����BST�Ͷ��ֲ��ҵĹ�ϵ������ܺ�д��
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
