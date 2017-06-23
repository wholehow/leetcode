package array;

import java.util.HashMap;

/*
	���⣺
	����һ���������飬������������������ӵó�Ŀ�����ֵ����ֵ�λ�á�
	����Լ����������붼��һ�����������

	���ӣ�
	���� nums = [2, 7, 11, 15], target = 9,
	��Ϊ nums[0] + nums[1] = 2 + 7 = 9, ���� [0, 1]��
*/

public class Solution1 {
	
    /* �����ĿҪ��ֱ�ӷ����������֣�����ʹ�þ����˫ָ�뷨
     * public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }*/
	
	/* �����㷨���Ǵ�ͷ��β������ÿ�ζ�ȥ��¼��ǰ������������������Ƿ�Ϊtarget��
	 * ����ѭ��ʱ�临�Ӷ�ΪO(N^2)��
	 * ��������������һ�Ǽ�¼���ֹ������֣�
	 * ����Ҫ��¼�������ڵ�λ�ã�������������Ȼ��λ�þͲ�֪���ˡ�
	 * �������ʹ��˫ָ�뷨����Ҫ�µ����ݽṹ��¼δ����ǰ��λ�á�
	 * ���ǿ���ʹ��HashMap����¼����������ÿ�γ��ֵ����ּ���λ�ã�
	 * ��ֵ��key��λ����ֵ
	 */
	
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[0]);
				res[i] = i;
				return res;
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
