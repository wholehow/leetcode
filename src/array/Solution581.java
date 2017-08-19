package array;

import java.util.Arrays;

/* ���⣺
 * ����һ�������飬�ҵ����е����δ���������鲢�����䳤�ȡ�
 * 
 * ʾ����
 * ���룺[2, 6, 4, 8, 10, 9, 15]
 * �����5����Ϊ[6, 4, 8, 10, 9]�����δ���������飬�䳤��Ϊ5��
 * */

public class Solution581 {
	
	/* ������Ŀ�е�����Ҳ���ѷ����������������ҳ������е�����Ĳ��֡�
	 * һ������˼·�Ǹ���ԭ���鵽һ���µ����飬Ȼ��Ƚ�������������ͬλ�ò�ͬ�Ĳ��־�������Ĳ��֡�
	 * �������£�
	 *
	 public int findUnsortedSubarray(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int[] tmp = nums;
		Arrays.sort(tmp);
		int i = 0;
		int j = nums.length - 1;
		while (i < nums.length && nums[i] == tmp[i]) {
			i++;
		}
		while (j >= 0 && nums[j] == tmp[j]) {
			j--;
		}
		return j - i + 1;
	}
	/* ����һ��˼·������Ƚϣ�����ÿ��λ�õ�������ǰ��������бȽϣ����С�ھ���������������Ҫ��������ǰ�ƶ���
	 * ��Ҫһ���α��¼���ƶ�����λ�á��������ַ����Ƚϸ��ӣ�ʱ�临�Ӷ���O(N^2)��
	 * 
	 * ��ʵ�Ҹ���Ŀ�Ƚϼ򵥡���Ϊֻ��Ҫȷ������Ĳ��֣���������Ҫ������Ĳ��ֽ�������
	 * ��ʵ���ﻹ��˫ָ�뷨��ֻ����˫ָ�벻��һ��ѭ���ж��Ƿŵ�������ѭ���У��ֱ��¼�����ͷ��β��
	 * */
	
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //���򲿷�β��һ����nums[i] > min
        int min = nums[nums.length - 1];
        int noMinIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(nums[i], min);
            }
        }
        //�����һ��while������ʱ��noMinIndex����-1��˵���������鶼������ģ�ֱ�ӷ���0������һ��whileѭ����
        if (noMinIndex == -1) {
            return 0;
        }
        //���貿��ͷ��һ����nums[i] < max
        int max = nums[0];
        int noMaxIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(nums[i], max);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }
}
