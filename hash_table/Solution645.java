package hash_table;

import java.util.HashSet;
import java.util.Set;

/* ���⣺
 * ����S���������1��n�����֡������ҵ��ǣ��������ݴ��󣬼����е�һ�����ֱ����Ƶ������е���һ�����֣��⵼���ظ�һ�����ֲ���ʧ��һ�����֡�
 * ����һ������nums��ʾ�����ü��ϵ�����״̬����������������ҵ����ַ������Σ�Ȼ���ҵ�ȱ�ٵ����֡����������ʽ�������ǡ�
 * ���磺
 * ���룺nums = [1,2,2,4]
 * �����[2,3]
 * */

public class Solution645 {
	
	/* ���������ҵ��������ε������Լ��ҵ���ʧ�����֡�
	 * ʹ��Set�ҵ��ظ����ֵ����֣�ʹ�õȲ�������͹�ʽ�ҵ���ʧ�����֡�
	 * */
	
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return null;
        }
        Set<Integer> set = new HashSet<>();
        int dup = 0, len = nums.length;
        long sum = (len * (len + 1)) / 2;
        for (int num : nums) {
        	if (set.contains(num)) {
        		dup = num;
        	}
        	sum -= num;
        	set.add(num);
        }
        return new int[] { dup, (int)(dup + sum) };
    }
}
