package divide_and_conquer;

/* 大意：
 * 未排序数组中和最大的子数组（至少包含一个数字）。
 * 
 * 例如：
 * 输入：[-2,1,-3,4,-1,2,1,-5,4]
 * 输出：[4,-1,2,1]的最大和为6。
 * */

public class Solution53 {
	
	/* 这题是一道经典的贪心问题，我们可以很容易的得到其dp方程，假设dp[i]是数组nums[0, i]区间最大的值，那么
	 * dp[i + 1] = max(dp[i], dp[i] + nums[i + 1])
	 * */
	
    /*public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);	// 因为有可能变成负数
        }
        return max;
    }*/
	
	/* 虽然这道题目用dp解起来很简单，但是题目说了，问我们能不能采用divide and conquer的方法解答，也就是二分法。
	 * 假设数组nums[left, right]存在最大区间，mid = (left + right) / 2，那么无非就是三中情况：
	 * 1.最大值在nums[left, mid - 1]里面
	 * 2.最大值在nums[mid + 1, right]里面
	 * 3.最大值跨过了mid，也就是我们需要计算[left, mid - 1]区间的最大值，以及[mid + 1, right]的最大值，
	 * 然后加上mid，三者之和就是总的最大值
	 * */
	
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return divideConquer(nums, 0, nums.length - 1, Integer.MIN_VALUE);
	}
	private int divideConquer(int[] nums, int left, int right, int tmpMax) {
		if (left > right) {
			return Integer.MIN_VALUE;
		}
		int mid = left + (right - left) / 2;
		//1.最大值在nums[left, mid - 1]里面
		int lmax = divideConquer(nums, left, mid, tmpMax);  //得到子区间[left, mid - 1]最大值
		//2.最大值在nums[mid + 1, right]里面
		int rmax = divideConquer(nums, mid + 1, right, tmpMax);  //得到子区间[mid + 1, right]最大值
		
		tmpMax = Math.max(tmpMax, lmax);
		tmpMax = Math.max(tmpMax, rmax);
		
		//3.最大值跨过了mid
		int sum;
		//得到[left, mid - 1]最大值
		sum = 0; 
		int mlmax = 0;
		for (int i = mid - 1; i >= left; i--) {
			sum += nums[i];
			mlmax = Math.max(mlmax, sum);
		}
		//得到[mid + 1, right]最大值
		sum = 0;
		int mrmax = 0;
		for (int i = mid + 1; i <= right; i++) {
			sum += nums[i];
			mrmax = Math.max(mrmax, sum);
		}
		tmpMax = Math.max(tmpMax, mlmax + mrmax + nums[mid]);
		return tmpMax;
	}
}
