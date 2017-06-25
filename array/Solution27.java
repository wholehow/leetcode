package array;

/* 大意：
 * 给出一个数组和一个数，移除数组中所有等于该数的值并返回新长度。
 * 不要使用额外的空间来创建另一个数组，你必须在恒定的内存中做。
 * 元素的顺序可以改变。新长度以外的内容无所谓是什么样子。
 * */

public class Solution27 {
	
	/* 这道题的要求在于不创建新数组，而是在原有的数组内容来进行操作，
	 * 按题目的意思就是将所有不等于那个值的数放到数组前面，然后返回这些数的数量，也就是数组的一个长度，
	 * 这个长度后面的数是什么样子的都没有关系。
	 * */
	
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pos = 0;
        for (int curNum : nums) {
            if (curNum != val) {
                nums[pos++] = curNum;
            }
        }
        return pos;
    }
}
