package array;

/* 最大子数组乘积。
 * 找到数组中包含子数组的最大乘积（至少包含一个数字）。
 * */

public class Solution152 {
	
	/* 有点类似寻找数组中乘积最大的三个数/四个数。
	 * 假设curMax，curMin分别代表当前最大乘积和最小乘积。因为数组中可以有负数，所以下一次最大乘积一定是
	 * 上一次最大/最小乘积与当前数的乘积和当前数中较大者。
	 * */
	
    public int maxProduct(int[] nums) {
    	// pre用于保存当前次结果作为下一次参与比较
        int curMaxPre = nums[0], curMinPre = nums[0];
        int rst = nums[0];	// 保存最终结果
        int curMax, curMin;
        for (int i = 1; i < nums.length; i++) {
        	curMax = Math.max(Math.max(curMaxPre * nums[i], curMinPre * nums[i]), nums[i]);
        	curMin = Math.min(Math.min(curMaxPre * nums[i], curMinPre * nums[i]), nums[i]);
        	rst = Math.max(curMax, rst);	// 注意这里不要写成curMax和curMin中的较大者
        	curMaxPre = curMax;
        	curMinPre = curMin;
        }
        return rst;
    }
}
