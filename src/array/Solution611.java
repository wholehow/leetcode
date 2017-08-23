package array;

import java.util.Arrays;

/* 大意：
 * 给定一个由非负整数组成的数组，你的任务是计算从数组中选择的三元组数，如果将它们作为三角形的边长，可以形成三角形。
 * 例如：
 * 输入：[2,2,3,4]
 * 输出：3，解释2,3,4 (使用第一个2)，2,3,4 (使用第二个2)，2,2,3
 * */

public class Solution611 {
	
	/* 三角形三边关系：a+b>c,a-b<c。
	 * 当然上述关系实在不知道abc大小的前提。因此为了简单我们事先使用排序对nums进行排序。
	 * 使用两个指针，left每次初始化为0，right每次初始化为i-1。每次需要比较的是nums[left]+nums[right]和当前nums[i]的
	 * 大小关系。因此总的时间复杂度为O(N^2)。
	 * */
	
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
        	return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
        	int left = 0, right = i - 1;
        	while (left < right) {
        		if (nums[left] + nums[right] > nums[i]) {
        			// 如果两个小元素（left和right）的和大于最右边的元素（最大），那么很明显，后续的数对总将大于最右边元素
        			// res += right - left的原因是找出有多少对满足此属性
        			res += right - left;
        			right--;
        		} else {
        			left++;
        		}
        	}
        }
        return res;
    }
}
