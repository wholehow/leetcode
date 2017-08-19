package array;

import java.util.*;

/* ���⣺
	����һ���������飬����1 �� a[i] �� n (n = ���鳤��)��һЩԪ�س������Σ������ĳ���һ�Ρ�
	Ѱ������[1, n]��û�г����������е�Ԫ�ء�
	���Բ�ʹ�ö���ռ䲢��O(n)����ʱ�����������Լ��践���б������ռ�
 */

public class Solution448 {	
	
	/* ���鳤��Ϊn��������Ԫ�ص�ȡֵ��ΧΪ[1, n]������index��ΧΪ[0, n - 1]��
	 * Ҳ����˵�������Ԫ��û���ظ�����ô����ÿ��Ԫ��k������Ӧһ��index = k - 1.
	 * ��˿�������������ʣ������ֵ�Ԫ������Ӧ��index�����Ԫ���ø���(�����ű�Ƿ�����ʵ��������������)
	 * ������ʾ��index����Ӧ��Ԫ�ش��ڣ���nums[index] = - nums[index], ��ʾindex + 1 ������Ǵ��ڵģ���
	 * �������������ÿ��Ԫ�ؽ����������֮���ٱ���һ�����飬���ĳ��index�ϵ�Ԫ��nums[index] �Ǹ���
	 * ��˵����index����Ӧ��Ԫ��(index + 1)û�г��ֹ�����(index + 1)����Ҫ���ص�List��
	 * */
	
	 public List<Integer> findDisappearedNumbers(int[] nums) {
		 //��Ŀ�Կӣ�ֻ����[]�������������NULL�����T-T
		 List<Integer> resList = new ArrayList<Integer>();
		 if (nums == null || nums.length == 0) {
			 return resList;
		 }
		 for (int curNum : nums) {
			 int index = Math.abs(curNum) - 1;
			 nums[index] = nums[index] > 0 ? -nums[index] : nums[index]; 
			 }
		 for (int i = 0; i < nums.length; i++) {
			 if (nums[i] > 0) {
				 resList.add(i + 1);
			 }
		 }
		 return resList;
	 }
}
