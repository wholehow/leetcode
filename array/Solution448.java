package array;

import java.util.*;

/* 大意：
 * 给定一个整数数组，其中1 ≤ a[i] ≤ n (n = 数组长度)，一些元素出现两次，其他的出现一次。
 * 寻找所有[1, n]中没有出现在数组中的元素。
 * 可以不使用额外空间并在O(n)运行时间求解吗？你可以假设返回列表不算额外空间
 */

public class Solution448 {	
	
	/* 数组长度为n，数组中元素的取值范围为[1, n]，数组index范围为[0, n - 1]。
	 * 也就是说如果数组元素没有重复，那么对于每个元素k，都对应一个index = k - 1.
	 * 因此可以利用这个性质，将出现的元素所对应的index上面的元素置负，(正符号标记法，其实就是做个二分类)
	 * 用来表示该index所对应的元素存在（将nums[index] = - nums[index], 表示index + 1 这个数是存在的）。
	 * 遍历整个数组对每个元素进行这个操作之后，再遍历一遍数组，如果某个index上的元素nums[index] 非负，
	 * 则说明该index所对应的元素(index + 1)没有出现过，则将(index + 1)加入要返回的List。
	 * */
	
	 public List<Integer> findDisappearedNumbers(int[] nums) {
		 //题目略坑，只接受[]的输出，不接受NULL的输出T-T
		 List<Integer> resList = new ArrayList<Integer>();
		 if (nums == null || nums.length == 0) {
			 return resList;
		 }
		 for (int curNum : nums) {
			 int index = Math.abs(curNum) - 1;
			 nums[index] = nums[index] > 0 ? -nums[index] : nums[index]; 
			 }
		 for (int i = 0; i < nums.length; i++) {
			 if (nums[i] > 0) {
				 resList.add(i + 1);
			 }
		 }
		 return resList;
	 }
}
