package array;

import java.util.Arrays;

/* 大意：
 * 在旋转排序数组中查找最小值。
 * 假设以升序排列的数组在预先知道的枢轴上发生了旋转。
 * 即0 1 2 4 5 6 7可能变成了4 5 6 7 0 1 2。
 * 找到其中最小的元素。可以假设数组中不存在重复值。
 * */

public class Solution153 {
	
	/* 先给出一个比较无耻的写法。
	 * */
	
    /*public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }*/
    
    /* 既然上面的示例可以通过，说明题目让我们实现的就是这个排序。
     * 更改二分查找。题目同162。
     * */
	
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		
		int start = 0, end = nums.length -1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid > 0 && nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}
			if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {	// 注意小于等于号
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return nums[start];
	}
}
