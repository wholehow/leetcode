package sort;

import java.util.Arrays;

/* 大意：
 * 给定一个未排序的数组nums，重新排序它使得nums [0] <nums [1]> nums [2] <nums [3] ....
 * 你可以在O(n)时间复杂度和O(1)空间复杂度实现么？
 * */

public class Solution324 {
	
	/* O(N)O(1)的方法太难了，实在想不出来。
	 * 想到一种比较直接的方法。
	 * 首先对原数组进行排序然后复制。
	 * 由于现在的nums和temp是有序的，那么我们将nums中每两个位置中前面的那个数进行变化，变为mid-i位置的数。
	 * */
	
	public void wiggleSort(int[] nums) {
	    Arrays.sort(nums);
	    int n = nums.length, mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
	    int[] temp = Arrays.copyOf(nums, n);	// 数组复制
	    int idx = 0;
	    for (int i = 0; i <= mid; i++){
	        nums[idx] = temp[mid - i];
	        if (idx + 1 < n)	// 还没走到最后
	            nums[idx + 1] = temp[n - i - 1];
	        idx += 2;
	    }
	}
}
