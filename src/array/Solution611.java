package array;

import java.util.Arrays;

/* ���⣺
 * ����һ���ɷǸ�������ɵ����飬��������Ǽ����������ѡ�����Ԫ�����������������Ϊ�����εı߳��������γ������Ρ�
 * ���磺
 * ���룺[2,2,3,4]
 * �����3������2,3,4 (ʹ�õ�һ��2)��2,3,4 (ʹ�õڶ���2)��2,2,3
 * */

public class Solution611 {
	
	/* ���������߹�ϵ��a+b>c,a-b<c��
	 * ��Ȼ������ϵʵ�ڲ�֪��abc��С��ǰ�ᡣ���Ϊ�˼���������ʹ�������nums��������
	 * ʹ������ָ�룬leftÿ�γ�ʼ��Ϊ0��rightÿ�γ�ʼ��Ϊi-1��ÿ����Ҫ�Ƚϵ���nums[left]+nums[right]�͵�ǰnums[i]��
	 * ��С��ϵ������ܵ�ʱ�临�Ӷ�ΪO(N^2)��
	 * */
	
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
        	return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
        	int left = 0, right = i - 1;
        	while (left < right) {
        		if (nums[left] + nums[right] > nums[i]) {
        			// �������СԪ�أ�left��right���ĺʹ������ұߵ�Ԫ�أ���󣩣���ô�����ԣ������������ܽ��������ұ�Ԫ��
        			// res += right - left��ԭ�����ҳ��ж��ٶ����������
        			res += right - left;
        			right--;
        		} else {
        			left++;
        		}
        	}
        }
        return res;
    }
}
