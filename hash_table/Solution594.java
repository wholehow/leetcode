package hash_table;

import java.util.HashMap;
import java.util.Map;

/* 大意：
 * 我们定义一个和谐数组是一个数组，其最大值和最小值之间的差值恰好为1。
 * 现在，给定一个整数数组，你需要在其所有可能的子序列之间找到它最长的和谐子序列的长度。
 * 例如：
 * 输入：[1,3,2,2,5,2,3,7]
 * 输出：5，最长的和谐子序列是[3,2,2,2,3]。
 * */

public class Solution594 {
	
	/* 有序不用返回子序列的形式，只需要返回其形式，这样就比较简单了。
	 * 首先利用HashMap统计每个数字出现的次数。需要的差值为1，即map.containsKey(key+1)需要在map中。
	 * 每次结果值为map.get(key+) + map.get(key)与result中的较大者。
	 * */
	
    public int findLHS(int[] nums) {
        if (nums == null || nums.length < 0) {
			return -1;
		}
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int rst = 0;
        for (int key : map.keySet()) {
        	if (map.containsKey(key + 1)) {
        		rst = Math.max(rst, map.get(key + 1) + map.get(key));
        	}
        }
        return rst;
    }
}
