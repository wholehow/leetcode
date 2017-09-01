package array;

import java.util.Arrays;

/* �����ǿ��������飬��ʹ�������е�����Ԫ�ؾ���ȵ���С�ƶ�������һ���ƶ���ָ��ĳ��Ԫ�ؼ�1���߼�1��
 * */

public class Solution462 {
	
	/* 1.����ÿ�ζ�ֻ�ܼ�1���߼�1�������Ǹɴ�㣬�����������ÿ����������ͷ�������в�ֵ���㣬�����ó��Ľ��һ����
	 * ��Ҫ�ƶ��Ĵ���֮�͡���Ϊ���ܴ�����С��������Ҫ���һ����ͬ������
	 * */
	
/*    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }*/
    
    /* 2.˼·ͬ1���������������˱仯�����Ƕ�����λ��ȥ�仯��
     * */
    
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0, mid = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            res += i > mid ? nums[i] - nums[mid] : nums[mid] - nums[i];
        }
        return res;
    }
}
