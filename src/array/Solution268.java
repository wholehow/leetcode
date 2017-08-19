package array;

/* 大意：
 * 给出一个包含n个数字的数组，数字范围为 0, 1, 2, ..., n，寻找数组遗失的那个数字。
 * 例子： 给出 nums = [0, 1, 3] 返回 2。
 * 注意： 你的算法需要在线性时间复杂度内运行。能不能使用恒定的额外空间复杂度？
 * */

public class Solution268 {
	
	/* 一种思路是利用等差数组求和0-N，然后求出nums数组的和，两个和做差即为丢失的那个数字。
	 * 但是要特殊考虑到0。
	 * 但是更好的办法是利用异或运算的性质。
	 * */
	
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int xor = 0;
        int i = 0;
	    for (; i < nums.length; i++) {
		    xor = xor ^ i ^ nums[i];
	    }
	    return xor ^ i;
    }
}
