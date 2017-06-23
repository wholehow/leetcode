package array;

/* 大意：
 * 输入：[1,1,0,1,1,1]（只由0和1组成的数组）
 * 输出：3
 * 即求最大连续1的个数
 * 
*/

public class Solution485 {
	
	/* 遍历一遍数组，用一个计数器cnt来统计1的个数，
	 * 方法是如果当前数字为0，那么cnt重置为0，如果不是0，cnt自增1，
	 * 然后每次更新结果res即可
	*/
	
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        int res = 0;
        for (int curNum : nums) {
            cnt = curNum == 0 ? 0 : cnt + 1; 
            //也可以采用乘法，因为只有0和1
            //cnt = (curNum + cnt) * curNum;
            res = Math.max(cnt, res);
        } 
        return res;
    }
}
