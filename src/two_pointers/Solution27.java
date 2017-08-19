package two_pointers;

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
	
    /*public int removeElement(int[] nums, int val) {
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
    }*/
	
	/* 由于只是返回长度而无需在意最后数组的形式，因此我们可以考虑将最后的数依次移动到前面出现重复的位置上进行覆盖，
	 * 这样只需要两个指针轻松搞定。
	 * 注意最后的返回结果，是处理的结果数组的长度=下标+1。
	 * */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int pointer = nums.length - 1;
        while (i <= pointer) {
            if (nums[i] == val) {
                nums[i] = nums[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }
}
