package two_pointers;

/* 大意：
 * 给出一个有序数组，移除重复的数字，让每个元素只出现一次，并返回新的长度。
 * 不要分配额外的空间给另一个数组，你必须在固定的内存下去做。
 * 举例： 给出输入的数组为 nums = [1,1,2]，
 * 你的函数应该返回长度 = 2，并让前面两个数字为单独的1和2。在新长度之外的位置无所谓你留下了什么内容。
 */

public class Solution26 {
	
	/* 双指针法来了。
	 * 初始 j = 0, i = 1。
	 * 假设现在i = j + 1，如果nums[i] == nums[j]，那么我们递增i，直到nums[i] != nums[j]，
	 * 这时候我们再设置nums[j + 1] = nums[i]，同时递增i和j，重复上述过程直到遍历结束。
	 * 考虑数组 nums = [1, 1, 2, 3]
	 * 首先i = 1，j = 0，这时候nums[i] =numsA[j]，于是递增i，碰到2，不等于1，
	 * 此时设置nums[j + 1] = nums[i]，也就是nums[1] = nums[2]，递增i和j为3和1，这时候nums[3] != nums[1]，
	 * 设置nums[j + 1] = nums[i]，也就是nums[2] = nums[3]，再次递增，遍历结束。
	 * 这时候新的数组长度就为2 + 1，也就是3。
	 * */
	
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
    
    /*一种更好理解的写法*/
    /* position即为最后在nums中走到的位置
     * lastNumber为上个nums[i]的值
     * */
    /*public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
        int position = 1;
        int lastNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lastNumber) {
                nums[position] = nums[i];
                position++;
                lastNumber = nums[i];
            }
        }
        return position;
    }*/
}
