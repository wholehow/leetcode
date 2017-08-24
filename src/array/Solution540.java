package array;

/* 有序数组中只出现一次的数。
 * */

public class Solution540 {
	
	/* 既然是有序数组，使用二分查找.
	 * 单个数只能出现在奇数位置或偶数位置
	 * */
	
	public int singleNonDuplicate(int[] nums) { 
		int low = 0, high = nums.length - 1;
		while(low < high) {
			int mid = (low + high)/2;
		    if (mid % 2 == 0 && nums[mid] == nums[mid + 1]) {	// 偶数情况
		    	low = mid + 1;
		    } else if (mid % 2 == 1 && nums[mid - 1] == nums[mid]) {	// 奇数情况
		        low = mid + 1;
		    } else {
		        high = mid;
		    }
		}
		return nums[low];
	}
}
