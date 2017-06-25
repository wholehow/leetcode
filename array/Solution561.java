package array;

import java.util.Arrays;

/* ���⣺
 * ����һ������Ϊ2n���������飬������ֳ�n�飬��ÿ��������Сֵ֮�͵����ֵ��
 * 
 * ���磺
 * ���룺[1,4,3,2]
 * �����4
 * ����n = 2��4 = min(1, 2) + min(3, 4)
 * */

public class Solution561 {
	
	/* ��������Ҫ��ȡ����2N��С������ָ��N���ÿ����С���ĺ͡�
	 * ������ʹ������������������ÿ��ȡ��ÿһ��Ľ�С��ֱ�����
	 * ���ɵõ����ؽ����ʡȥ�˱ȽϵĹ��̡�
	 * */
	
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
