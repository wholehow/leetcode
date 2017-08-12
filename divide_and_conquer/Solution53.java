package divide_and_conquer;

/* ���⣺
 * δ���������к����������飨���ٰ���һ�����֣���
 * 
 * ���磺
 * ���룺[-2,1,-3,4,-1,2,1,-5,4]
 * �����[4,-1,2,1]������Ϊ6��
 * */

public class Solution53 {
	
	/* ������һ�������̰�����⣬���ǿ��Ժ����׵ĵõ���dp���̣�����dp[i]������nums[0, i]��������ֵ����ô
	 * dp[i + 1] = max(dp[i], dp[i] + nums[i + 1])
	 * */
	
    /*public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);	// ��Ϊ�п��ܱ�ɸ���
        }
        return max;
    }*/
	
	/* ��Ȼ�����Ŀ��dp�������ܼ򵥣�������Ŀ˵�ˣ��������ܲ��ܲ���divide and conquer�ķ������Ҳ���Ƕ��ַ���
	 * ��������nums[left, right]����������䣬mid = (left + right) / 2����ô�޷Ǿ������������
	 * 1.���ֵ��nums[left, mid - 1]����
	 * 2.���ֵ��nums[mid + 1, right]����
	 * 3.���ֵ�����mid��Ҳ����������Ҫ����[left, mid - 1]��������ֵ���Լ�[mid + 1, right]�����ֵ��
	 * Ȼ�����mid������֮�;����ܵ����ֵ
	 * */
	
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return divideConquer(nums, 0, nums.length - 1, Integer.MIN_VALUE);
	}
	private int divideConquer(int[] nums, int left, int right, int tmpMax) {
		if (left > right) {
			return Integer.MIN_VALUE;
		}
		int mid = left + (right - left) / 2;
		//1.���ֵ��nums[left, mid - 1]����
		int lmax = divideConquer(nums, left, mid, tmpMax);  //�õ�������[left, mid - 1]���ֵ
		//2.���ֵ��nums[mid + 1, right]����
		int rmax = divideConquer(nums, mid + 1, right, tmpMax);  //�õ�������[mid + 1, right]���ֵ
		
		tmpMax = Math.max(tmpMax, lmax);
		tmpMax = Math.max(tmpMax, rmax);
		
		//3.���ֵ�����mid
		int sum;
		//�õ�[left, mid - 1]���ֵ
		sum = 0; 
		int mlmax = 0;
		for (int i = mid - 1; i >= left; i--) {
			sum += nums[i];
			mlmax = Math.max(mlmax, sum);
		}
		//�õ�[mid + 1, right]���ֵ
		sum = 0;
		int mrmax = 0;
		for (int i = mid + 1; i <= right; i++) {
			sum += nums[i];
			mrmax = Math.max(mrmax, sum);
		}
		tmpMax = Math.max(tmpMax, mlmax + mrmax + nums[mid]);
		return tmpMax;
	}
}
