package bit_manipulation;

/* 大意：
 * 整数型数组中，每个元素均出现两次，除了一个元素例外，如何找出这个元素？能否设计一个线性时间的算法，且不需要额外的存储空间？
 * */

public class Solution136 {
	
	/* 位运算怎么少的了异或操作
	 * */
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
