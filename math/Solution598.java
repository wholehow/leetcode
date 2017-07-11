package math;

/* 大意：
 * 给定m * n矩阵M，初始为0，然后执行一些更新操作。
 * 数组ops表示一组更新操作，每一个操作(a, b)，表示将矩阵0 <= i < a 并且 0 <= j < b的区域值+1。
 * 进行若干操作后，求矩阵的最大值。
 * 例如：
 * 输入m = 3, n = 3，operations = [[2,2],[3,3]]
 * 输出：4 解释
 * 初始M=[[0, 0, 0],
 	 [0, 0, 0],
 	 [0, 0, 0]]
   [2,2]之后, M =[[1, 1, 0],
 		 [1, 1, 0],
 		 [0, 0, 0]]
   [3,3]之后, M = [[2, 2, 1],
 		  [2, 2, 1],
 		  [1, 1, 1]]
 * 矩阵中最大的值为2，共有4个位置值为4，返回4。
 * */

public class Solution598 {
	
	/* 只要找到二维坐标的第一个坐标的最小值和第二个坐标的最小值相乘即可
	 * */
	
    public int maxCount(int m, int n, int[][] ops) {  
        int min_a = Integer.MAX_VALUE;  
        int min_b = Integer.MAX_VALUE;  
        for (int[] tmp : ops) {  
            if (tmp[0] < min_a)  
                min_a = tmp[0];  
            if (tmp[1] < min_b)  
                min_b = tmp[1];  
        }  
        return min_a != Integer.MAX_VALUE && min_b != Integer.MAX_VALUE ? min_a * min_b : m * n;  
    }  
}
