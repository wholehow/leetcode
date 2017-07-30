package array;

import java.util.ArrayList;
import java.util.Arrays;

/* ����һ�����ܰ����ظ����ֵ���������nums���������п��ܵ��Ӽ���
 * ע�⣺�𰸼����ܰ����ظ����Ӽ���
 * ���磺
 * ���룺nums = [1,2,2]
 * �����[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * */

public class Solution90 {
	
	/* һ������N�������ļ��ϵ��Ӽ�����2^N���������ظ��ľ���ʣ�µġ��ؼ�������ҵ��ظ����Ӽ���
	 * ����[1,2,2]��˵���ڵ�����1֮������Ϊ[[], [1]]��������һ��2��[[], [1], [2], [1,2]]��
	 * ��������Ҫ�����ظ���Ԫ��2�ˣ���ʱ��������ڵ�����һ��2֮ǰ�ʹ��ڵĽ����Ԫ�أ�[[], [1]]��ʱ���ͻ�����ظ���
	 * ����ֻ������һ�ֵ����������µĽ���м�����ӡ�����Ҫһ������ı�������ʾ�ڽ�����е��ĸ�λ�ÿ�ʼ������
	 * */
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }
    
    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        // �Ӽ�����ζ�Ų�����Ҫ��������Ԫ�أ�����ж�������<=
        // ���pos>nums.length�޷���ֵ
        if (pos <= nums.length) {
        	res.add(new ArrayList<>(tmpRes));
        }
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i-1]) 
            	continue;   // �����ظ�
            tmpRes.add(nums[i]);
            helper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}
