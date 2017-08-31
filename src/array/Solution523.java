package array;

import java.util.HashMap;
import java.util.Map;

/* 给定非负数数组和目标整数k，写一个函数来检查数组是否具有至少长度为2的连续子序列，其总和为k的倍数，即总和为n * k，其中n也是整数。
 * */

public class Solution523 {
	
	/* 充分利用取余操作。如果当前位置i对k取余为x，j位置对k取余为x，那么说明i和j之间一定间隔k的整数倍。
	 * 为了能够更快找到这种对于关系，利用Map，寻找之前是否存在相同的余数作为value。
	 * */
	
	public boolean checkSubarraySum(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>(){
	    	{
	    		put(0,-1);	// 初始化，因为之后用到i-prev
	    	}
	    };
	    int runningSum = 0;
	    for (int i = 0; i < nums.length; i++) {
	        runningSum += nums[i];
	        if (k != 0) {
	        	runningSum %= k; // 累积余数和
	        }
	        int prev = map.get(runningSum);
	        if (prev != 0) {
	            if (i - prev > 1) {	// 出现，当前位置i对k取余为x，j位置对k取余为x，那么说明i和j之间一定间隔k的整数倍
	            	return true;
	            }
	        }
	        else map.put(runningSum, i);
	    }
	    return false;
	}
}
