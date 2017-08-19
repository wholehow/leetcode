package bit_manipulation;

import java.util.Arrays;

/* ���⣺
 * ����һ���ߴ�Ϊn�����飬�ҵ���Ҫ��Ԫ�ء�
 * ��ν��Ҫ��Ԫ����ָ���ִ�������n/2��Ԫ�ء� 
 * ����Լ������鲻Ϊ������ҪԪ��һ�����ڡ�
 * */

public class Solution169 {
	
	/* ��򵥵�˼·��ֱ�Ӷ�nums������ô���ִ�������n/2��Ԫ��һ��������n/2��λ�á�
	 * ʱ�临�Ӷ���Ҫȡ��ȥ�����㷨��ѡ��
	 * */
	
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/
	
	/* �ڶ���˼·������������n/2�����Σ�����������n/k�����Ρ�
	 * ���ִ�������һ�����������һ���������ܲ����ڡ�
	 * ����һ����������ɾ��������ͬ��������ͣ��ɾ����ֱ��ʣ�µ���ֻ��һ�֡�
	 * ���һ�������ִ�������n/2�����һ������������
	 * */
	
	public int majorityElement(int[] nums) {
		int cand = 0;
		int times = 0;
		//�������ҵ������Ǵ�������n/2����
		for (int i = 0; i < nums.length; i++) {
			if (times == 0) {
				cand = nums[i];
			} else if (nums[i] == cand) {
				times++;
			} else {
				times--;
			}
		}
		times = 0;
		//�ж�ȷʵ����n/2��
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == cand) {
				times++;
				if (times > nums.length / 2) {
					break;
				}
			}
		}
		return cand;
	}
}
