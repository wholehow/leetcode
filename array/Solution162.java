package array;

/* 查找峰值元素。
 * 峰值元素是指当前值比他的邻居都大。
 * 给定一个元素都不重复的数组，查找其峰值元素。（num[i] ≠ num[i+1]）
 * 数组可能包含多个峰值，在这种情况下，返回任意一个索引都可以。
 * 你可以假设num [-1] = num [n] =-∞
 * 例如：
 * 输入：[1, 2, 3, 1]
 * 输出：3
 * */

public class Solution162 {
	
	/* 题目说了只要返回任意一个峰值元素的索引，那么我们可以直接返回找到的第一个峰值元素。
	 * 其实我觉得这个题目挺没水平的，真的对不起它medium的难度。
	 * 因为有num [-1] = num [n] =-∞这个条件的存在，这就是一个二分查找的题目。
	 * 因为不管找到的值在什么位置，哪怕是第一个或者是最后一个，因为有上面的条件的存在，返回结果一定成立。
	 * */
	
    public int findPeakElement(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
            	low = mid+1;
            } else {
            	high = mid;
            }
        }
        return low;
    }
}
