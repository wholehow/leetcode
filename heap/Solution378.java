package heap;

import java.util.PriorityQueue;

/* 寻找已排序矩阵中第k小的元素。
 * 输入：
 * matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
]，k=8
 * 输出：13
 * */

public class Solution378 {
	
	/* 堆排序
	 * */
	
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k < 0) {
        	return 0;
        }
        int cnt = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k + 1, (o1, o2) -> 
        matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
        pq.offer(new int[] {0, 0});
        while (true) {
        	int[] coordinates = pq.poll();	// coordinates是坐标
        	if (++cnt == k) {
        		return matrix[coordinates[0]][coordinates[1]];
        	}
        	if (coordinates[0] == 0 && coordinates[1] + 1 < matrix[0].length) {	// 水平添加
        		pq.offer(new int[]{0, coordinates[1] + 1});
        	}
            if (coordinates[0] + 1 < matrix.length) {	// 竖直添加
                pq.offer(new int[] {coordinates[0] + 1, coordinates[1]});
            }
        }
    }
    
    /* 二维空间二分查找
     * */
    
    /*public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }*/
}
