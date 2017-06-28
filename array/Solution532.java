package array;

import java.util.HashMap;
import java.util.Map;

/* ���⣺
 * �����������������k��Ѱ�����в��ظ��Ĳ�ֵΪk�����ԡ�
 * 
 * ���磺
 * 
 * ���룺[3, 1, 4, 1, 5], k = 2
 * �����2��������������(1, 3)��(3, 5)��
 * 
 * ���룺[1, 2, 3, 4, 5], k = 1
 * �����4�������ĸ�����(1, 2)��(2 , 3)��(3, 4)��(4, 5)��
 * */

public class Solution532 {
	
	/* ����k�п���Ϊ0����ֻ�к�������������ͬ�����ֲ����γ����ԣ���ô����˵������Ҫͳ��������ÿ�����ֵĸ�����
	 * ���ǿ��Խ���ÿ�����ֺ�����ִ���֮���ӳ�䣬Ȼ�������ϣ���е����֣�
	 * ���kΪ0�Ҹ����ֳ��ֵĴ�������1������res����1��
	 * ���k��Ϊ0�����õ�ǰ���ּ���k��õ���������Ҳ�������д��ڣ�����res����1��
	 * */
	
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
        	return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        int i = 0;
        //ÿ�����ֺ�����ִ���֮���ӳ��
        for (int num : nums) {
        	map.put(num, i++);
        }
        for (i = 0; i < nums.length; i++) {
        	if (map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {	//�����ظ�
        		map.remove(nums[i] + k);
            	res++;
        	}
        }
        return res;
    }
}
