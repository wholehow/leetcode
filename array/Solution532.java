package array;

import java.util.HashMap;
import java.util.Map;

/* 大意：
 * 给定整形数组和整数k，寻找所有不重复的差值为k的数对。
 * 
 * 例如：
 * 
 * 输入：[3, 1, 4, 1, 5], k = 2
 * 输出：2。共有两个数对(1, 3)和(3, 5)。
 * 
 * 输入：[1, 2, 3, 4, 5], k = 1
 * 输出：4。共有四个数对(1, 2)，(2 , 3)，(3, 4)，(4, 5)。
 * */

public class Solution532 {
	
	/* 由于k有可能为0，而只有含有至少两个相同的数字才能形成数对，那么就是说我们需要统计数组中每个数字的个数。
	 * 我们可以建立每个数字和其出现次数之间的映射，然后遍历哈希表中的数字，
	 * 如果k为0且该数字出现的次数大于1，则结果res自增1；
	 * 如果k不为0，且用当前数字加上k后得到的新数字也在数组中存在，则结果res自增1。
	 * */
	
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
        	return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        int i = 0;
        //每个数字和其出现次数之间的映射
        for (int num : nums) {
        	map.put(num, i++);
        }
        for (i = 0; i < nums.length; i++) {
        	if (map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {	//不能重复
        		map.remove(nums[i] + k);
            	res++;
        	}
        }
        return res;
    }
}
