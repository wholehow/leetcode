package math;

import java.util.Arrays;

/* ���⣺
 * �����������飬������������������˵����ֵ��
 * 
 * ��1��
 * ���룺[1,2,3]
 * �����6
 * 
 * ��2��
 * ���룺[1,2,3,4]
 * �����24
 * */

public class Solution628 {
	
	/* �����뵽��˼·��ɨ�裬��¼��ÿһ��λ�õ�ʱ��ǰ�ܵõ������˻�����Ȼ���ַ����ܼ򵥵���д�����Ƚϸ��ӣ�
	 * ��ΪҪά���ı���̫�ࣨ���ǵ�������������Ҫ6����
	 * ���õ�˼·��������
	 * ���A����Ϊ�������ĳ˻�һ���Ǻ��������ĳ˻���
	 * ���A����Ϊ�������ĳ˻�һ����ǰ�������ĳ˻���
	 * ���A�������������ĳ˻�һ���Ǻ����������һ�����ĳ˻�������ǰ���������һ�����ĳ˻���
	 * */
	
    public int maximumProduct(int[] nums) {
    	int len = nums.length;
    	Arrays.sort(nums);
    	int max1 = nums[0] * nums[1] * nums[2];
    	if (len == 3) {
			return max1;
		}
    	int max2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
    	int max3 = nums[0] * nums[1] * nums[len - 1];
    	int max4 = nums[0] * nums[len - 1] * nums[len - 2];
    	return Math.max(max1, Math.max(max2, Math.max(max3, max4)));
    }
}
