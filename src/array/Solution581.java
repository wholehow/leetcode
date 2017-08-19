package array;

import java.util.Arrays;

/* 大意：
 * 给定一整形数组，找到其中的最大未排序子数组并返回其长度。
 * 
 * 示例：
 * 输入：[2, 6, 4, 8, 10, 9, 15]
 * 输出：5，因为[6, 4, 8, 10, 9]是最大未排序子数组，其长度为5。
 * */

public class Solution581 {
	
	/* 根据题目中的例子也不难分析出来是让我们找出数组中的无序的部分。
	 * 一种最常规的思路是复制原数组到一个新的数组，然后比较两个数组在相同位置不同的部分就是无序的部分。
	 * 代码如下：
	 *
	 public int findUnsortedSubarray(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int[] tmp = nums;
		Arrays.sort(tmp);
		int i = 0;
		int j = nums.length - 1;
		while (i < nums.length && nums[i] == tmp[i]) {
			i++;
		}
		while (j >= 0 && nums[j] == tmp[j]) {
			j--;
		}
		return j - i + 1;
	}
	/* 还有一种思路是逐个比较，即将每个位置的数与它前面的数进行比较，如果小于就是无序，所有我们要将此数向前移动。
	 * 需要一个游标记录被移动到的位置。不过这种方法比较复杂，时间复杂度是O(N^2)。
	 * 
	 * 其实找个题目比较简单。因为只需要确定无序的部分，而并不需要对无序的部分进行排序。
	 * 其实这里还是双指针法，只不过双指针不在一个循环中而是放到了两个循环中，分别记录无序的头和尾。
	 * */
	
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //无序部分尾部一定有nums[i] > min
        int min = nums[nums.length - 1];
        int noMinIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(nums[i], min);
            }
        }
        //如果第一个while结束的时候，noMinIndex还是-1，说明整个数组都是有序的，直接返回0跳过下一个while循环。
        if (noMinIndex == -1) {
            return 0;
        }
        //无需部分头部一定有nums[i] < max
        int max = nums[0];
        int noMaxIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(nums[i], max);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }
}
