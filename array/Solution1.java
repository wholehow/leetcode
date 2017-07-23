package array;

import java.util.HashMap;

/*
	大意：
	给出一个整型数组，返回其中两个可以相加得出目的数字的数字的位置。
	你可以假设所有输入都有一个解决方案。

	例子：
	给出 nums = [2, 7, 11, 15], target = 9,
	因为 nums[0] + nums[1] = 2 + 7 = 9, 返回 [0, 1]。
*/

public class Solution1 {
	
    /* 如果题目要求直接返回两个数字，可以使用经典的双指针法*/
	
     public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
	
	/* 暴力算法就是从头到尾遍历，每次都去记录当前数字与其他数字相加是否为target。
	 * 两层循环时间复杂度为O(N^2)。
	 * 我们有两个需求，一是记录出现过的数字，
	 * 二是要记录数字所在的位置，不能做个排序然后位置就不知道了。
	 * 如果继续使用双指针法，需要新的数据结构记录未排序前的位置。
	 * 我们可以使用HashMap来记录遍历过程中每次出现的数字及其位置，
	 * 数值是key，位置是值
	 */
	
	/*public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[0]);
				res[i] = i;
				return res;
			}
			map.put(nums[i], i);
		}
		return null;
	}*/
}
