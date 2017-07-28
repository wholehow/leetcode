package array;

/* 大意：
 * 给定由n个整数组成的数组，找到具有最大平均值的给定长度k的连续子阵列。你需要输出最大平均值。
 * 注意：
 * 1.1 <= k <= n <= 30,000
 * 2.给定数组的元素将在[-10,000，10,000]的范围内。
 * 例子：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75，最大平均值为（12-5-6 + 50）/ 4 = 51/4 = 12.75
 * */

public class Solution643 {
	
	/* 使用类似滑动窗口的方式。每次保留的结果可以认为都是当前连续K长子序列的最大值。
	 * */
	
    public double findMaxAverage(int[] nums, int k) {
    	int sum = 0;
    	// 赋予sum初值为前K个数的和
    	for (int i = 0; i < k; i++) {
    		sum += nums[i];
    	}
    	int maxSum = sum;
    	for (int i = k ; i < nums.length; i++) {
    		sum += (nums[i] - nums[i - k]);
    		maxSum = Math.max(maxSum, sum);
    	}
    	// 不能使用强制类型转换，又学了一招
    	return maxSum / 1.0 / k;
    }
}
