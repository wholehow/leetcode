package binary_search;

/* 大意：
 * 给出一个递增排好序的整型数组，找出两个数组相加等于目标数字。
 * 函数 twoSum 应该返回两个数字的索引，index1 必须小于 index2。
 * 请注意你返回的结果（index1 和 index2）不是基于0开始的。
 * 你可以假设每个输入都有一个结果。
 * 例如：
 * 输入：numbers = {2, 7, 11, 15}, target = 9 
 * 输出：index1 = 1, index2 = 2
 */

public class Solution167 {
	
	/* 哈哈，经典的双指针法来了，只需要遍历一遍数组完美解决。
	 * 还有一种思路是在遍历的过程中使用二分查找，不过会让时间复杂度从O(N)变为O(NlogN)。
	 * */
	
	/*二分的思想
	 * 先固定第一个数，假设为nums[0], 那么在下标为1 .. n - 1上进行二分查找，查找有没有值为target - nums[0]。
	 * 固定第一个数为nums[1], 在 2 .. n - 1上二分查找。
	 */
	
	 public int[] twoSum(int[] numbers, int target) {
		 if (numbers == null || numbers.length < 2) {
			 return null;
		 }
		 int[] res = new int[2];
		 int right = numbers.length - 1;
		 for (int i = 0; i < numbers.length; i++) {
			 int tmp = target - numbers[i];
			 int left = i + 1;
			 while (left < right) {
				 int mid = left + (right - left) / 2;	//请注意这里mid的下标计算不同于标准的二分mid
				 if (numbers[mid] == tmp) {
					 res[0] = i + 1;
					 res[1] = mid;
					 return res;
				 } else if (numbers[mid] < tmp) {
					 left = mid + 1;
				 } else {
					 right = mid;
				 }
			 }
		 }
		 return null;
	 }
	
	/*双指针的思想*/
    /*public int[] twoSum(int[] numbers, int target) {
    	//不要使用判断条件target < 0，因为确实会出现那样的测试用例T-T
    	if (numbers == null || numbers.length < 2) {	
            return null;
        }
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }*/
}
