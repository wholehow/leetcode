package array;

import java.util.Arrays;

/* ���⣺
 * ����ת���������в�����Сֵ��
 * �������������е�������Ԥ��֪���������Ϸ�������ת��
 * ��0 1 2 4 5 6 7���ܱ����4 5 6 7 0 1 2��
 * �ҵ�������С��Ԫ�ء����Լ��������в������ظ�ֵ��
 * */

public class Solution153 {
	
	/* �ȸ���һ���Ƚ��޳ܵ�д����
	 * */
	
    /*public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }*/
    
    /* ��Ȼ�����ʾ������ͨ����˵����Ŀ������ʵ�ֵľ����������
     * ���Ķ��ֲ��ҡ���Ŀͬ162��
     * */
	
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		
		int start = 0, end = nums.length -1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid > 0 && nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}
			if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {	// ע��С�ڵ��ں�
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return nums[start];
	}
}
