package sort;

import java.util.Arrays;

/* ���⣺
 * ����һ��δ���������nums������������ʹ��nums [0] <nums [1]> nums [2] <nums [3] ....
 * �������O(n)ʱ�临�ӶȺ�O(1)�ռ临�Ӷ�ʵ��ô��
 * */

public class Solution324 {
	
	/* O(N)O(1)�ķ���̫���ˣ�ʵ���벻������
	 * �뵽һ�ֱȽ�ֱ�ӵķ�����
	 * ���ȶ�ԭ�����������Ȼ���ơ�
	 * �������ڵ�nums��temp������ģ���ô���ǽ�nums��ÿ����λ����ǰ����Ǹ������б仯����Ϊmid-iλ�õ�����
	 * */
	
	public void wiggleSort(int[] nums) {
	    Arrays.sort(nums);
	    int n = nums.length, mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
	    int[] temp = Arrays.copyOf(nums, n);	// ���鸴��
	    int idx = 0;
	    for (int i = 0; i <= mid; i++){
	        nums[idx] = temp[mid - i];
	        if (idx + 1 < n)	// ��û�ߵ����
	            nums[idx + 1] = temp[n - i - 1];
	        idx += 2;
	    }
	}
}
