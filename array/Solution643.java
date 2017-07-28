package array;

/* ���⣺
 * ������n��������ɵ����飬�ҵ��������ƽ��ֵ�ĸ�������k�����������С�����Ҫ������ƽ��ֵ��
 * ע�⣺
 * 1.1 <= k <= n <= 30,000
 * 2.���������Ԫ�ؽ���[-10,000��10,000]�ķ�Χ�ڡ�
 * ���ӣ�
 * ���룺[1,12,-5,-6,50,3], k = 4
 * �����12.75�����ƽ��ֵΪ��12-5-6 + 50��/ 4 = 51/4 = 12.75
 * */

public class Solution643 {
	
	/* ʹ�����ƻ������ڵķ�ʽ��ÿ�α����Ľ��������Ϊ���ǵ�ǰ����K�������е����ֵ��
	 * */
	
    public double findMaxAverage(int[] nums, int k) {
    	int sum = 0;
    	// ����sum��ֵΪǰK�����ĺ�
    	for (int i = 0; i < k; i++) {
    		sum += nums[i];
    	}
    	int maxSum = sum;
    	for (int i = k ; i < nums.length; i++) {
    		sum += (nums[i] - nums[i - k]);
    		maxSum = Math.max(maxSum, sum);
    	}
    	// ����ʹ��ǿ������ת������ѧ��һ��
    	return maxSum / 1.0 / k;
    }
}
