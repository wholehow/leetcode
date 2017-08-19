package array;

/* 大意：
 * 数组嵌套。
 * 给出由N个不同整数组成的零索引数组A。该数组包含[0，N-1]范围内的所有整数。
 * 设置0 <= K < N的S[K]定义如下：
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }
 * 集合S[K]对于每个K是有限的，不应包含重复项。
 * 写一个给定由N个整数组成的数组A的函数，返回该数组的最大集合S[K]的大小。
 * 例如：
 * 输入：A = [5,4,0,3,1,6,2]
 * 输出：4，A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2，
 * 其中最长的S [K]：S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * */

public class Solution565 {
	
	/* 用给出的输入结果进行模拟会发现最后的结果符合近世代数中闭包的概念，即：集合是循环的，只要找到最长集合中任意一个即可以
	 * 找到其他任何的。
	 * 用数组模拟DFS的过程。学到的思路是用负号标记所有已被访问过的数。
	 * */
	
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] >= 0) {
        		int len = 1, curVal = nums[i];	// 大于0代表未被访问过
        		while (Math.abs(curVal) != i) {	// 集合S是一个环
        			len++;
        			curVal = nums[Math.abs(curVal)];
        			if (nums[Math.abs(curVal)] > 0) {
        				nums[Math.abs(curVal)] *= -1;
        			}
        		}
            	rst = Math.max(len, rst);
        	}
        }
        return rst;
    }
}
