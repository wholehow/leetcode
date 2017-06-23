package array;

/* 大意：
 * 给出一个数字数组，写一个函数来移动其中的所有“0”到末尾，并保持其他非零元素的相对顺序不变。 
 * 比如说，给出数组 nums = [0, 1, 0, 3, 12]，调用函数之后，nums应该变成[1, 3, 12, 0, 0]。
 *  注意： 不能复制数组（空间复杂度(O(1)）。 
 *  使操作数尽可能地少（什么鬼？无法理解T-T）。
 */

public class Solution283 {
	
	/* 观察给出的实例发现，在经过移动后，所有非0的数仍保持相对有序。
	 * 这不就是稳定排序算法的变形么？而且还是数组中直接使用排序算法，忒方便了。
	 * 直接上直接插入排序，满足空间复杂度的要求。
	 * */
	
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return; 
        }       

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
            	nums[insertPos++] = num;
            }
        }        
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
