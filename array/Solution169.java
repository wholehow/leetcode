package array;

import java.util.Arrays;

/* 大意：
 * 给出一个尺寸为n的数组，找到主要的元素。
 * 所谓主要的元素是指出现次数超过n/2的元素。 
 * 你可以假设数组不为空且主要元素一定存在。
 * */

public class Solution169 {
	
	/* 最简单的思路：直接对nums排序，那么出现次数超过n/2的元素一定出现在n/2的位置。
	 * 时间复杂度主要取决去排序算法的选择。
	 * */
	
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
	
	/* 第二种思路：不仅适用于n/2的情形，还可以用于n/k的情形。
	 * 出现次数大于一半的数最多会有一个，还可能不存在。
	 * 我们一次在数组中删除两个不同的数，不停地删除，直到剩下的数只有一种。
	 * 如果一个数出现次数大于n/2，最后一定会留下来。
	 * */
	
	/*public int majorityElement(int[] nums) {
		int cand = 0;
		int times = 0;
		//首先是找到可能是次数大于n/2的数
		for (int i = 0; i < nums.length; i++) {
			if (times == 0) {
				cand = nums[i];
			} else if (nums[i] == cand) {
				times++;
			} else {
				times--;
			}
		}
		times = 0;
		//判断确实大于n/2次
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == cand) {
				times++;
				if (times > nums.length / 2) {
					break;
				}
			}
		}
		return cand;
	}*/
}
