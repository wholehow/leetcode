package array;


/* 大意：
 * 实现MATLAB的reshape函数功能。
 * 给定一个二维数组，两个正整数r和c。其中r代表行数，c代表列数。
 * 
 * 例如：
 * 输入：nums = [[1,2], [3,4]] r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 
 * 输入：nums = [[1,2], [3,4]] r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * */

public class Solution566 {
	
	/* 这种二维数组大小重新非配的问题的关键就是对应位置的坐标转换，
	 * 最直接的办法就是先把原数组拉直，变成一条直线，然后再组成新的数组。
	 * */
	
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (nums == null || m == 0) {
            return null;
        }
        if (m * n != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }
        return res;
    }
}
