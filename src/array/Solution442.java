package array;

import java.util.List;
import java.util.ArrayList;

/* �ҵ������������ظ���Ԫ�ء�
 * �����������飬1��a[i]��n��n=�����С������ЩԪ�س������Σ�����Ԫ�س���һ�Ρ�
 * �ҵ�����������г������ε�����Ԫ�ء�
 * �������O(1)�ռ��O(N)ʱ�������������
 * */

public class Solution442 {
	
	/* �о������Ŀ���м����ԣ���Ҫ�Ӹ�������1��a[i]��n��n=�����С�����֡�
	 * �������е�λ�ö����ظ�����ôλ��i���ֵ�������i-1��
	 * ���������Ȱ���ȷλ�õ����źã���ô�������ε���һ���ǳ����������ó��ֵ�λ�á�
	 * ������ǿ�������ǰ�����������ж��ظ�ȡ���ŵ�˼�롣
	 * �����ǰλ�õ���С��0��˵������ǰһ���Ѿ������ʲ��Һ͵�ǰ�����ظ��ģ����������һ���ظ�������
	 * */
	
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
        	return resList;
        }
        for (int i = 0; i < nums.length; i++) {
        	int idx = Math.abs(nums[i]) - 1;
        	if (nums[idx] < 0) {
        		resList.add(idx + 1);
        	}
        	nums[idx] = -nums[idx];
        }
        return resList;
    }
}
