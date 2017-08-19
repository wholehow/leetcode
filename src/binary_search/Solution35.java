package binary_search;

/* 大意：
 * 对于给定排好序的数组nums以及给定值target，在nums中查找nums[i] == target。
 * 如果找到就返回i，如果没找到则返回其应当被插入位置的下标。
 * 
 * 例如：
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * */

public class Solution35 {
	
	/* 感觉是二分查找的变种。
	 * 如果target存在于数组中，则二分查找一定能在O(longN)时间复杂度内找到。
	 * 关键在于target不在数组中，当二分查找结束，即start > end时，究竟应该如何获得插入位置。
	 * 这里考察的就是结束条件的分析。其实题目已经说的非常明白了，直接返回start即可。
	 * */
	
    public int searchInsert(int[] nums, int target) {
    	//我现在就感觉LeetCode有些判错条件真的让人非常无语。
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }	
}
