package tree;

/* ���⣺
 * �������ظ������顣һ���������������:
 * 1.����������ѡ����������Ϊ��
 * 2.��ѡ�������������������Ϊ�������ĸ�
 * 3.��ѡ�Ұ�����������������Ϊ�������ĸ�
 * 4.�ݹ�˹��̡�
 * */

public class Solution654 {
	
	/* �ݹ顣��maxIdx���浱ǰ���������
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
    	// max���浱ǰ���ֵ��maxIdx�����������
    	// ʹ��maxIdx���Ժܷ������Ĳ���
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
