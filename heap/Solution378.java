package heap;

import java.util.PriorityQueue;

/* Ѱ������������е�kС��Ԫ�ء�
 * ���룺
 * matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
]��k=8
 * �����13
 * */

public class Solution378 {
	
	/* ������
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
        	int[] coordinates = pq.poll();	// coordinates������
        	if (++cnt == k) {
        		return matrix[coordinates[0]][coordinates[1]];
        	}
        	if (coordinates[0] == 0 && coordinates[1] + 1 < matrix[0].length) {	// ˮƽ���
        		pq.offer(new int[]{0, coordinates[1] + 1});
        	}
            if (coordinates[0] + 1 < matrix.length) {	// ��ֱ���
                pq.offer(new int[] {coordinates[0] + 1, coordinates[1]});
            }
        }
    }
    
    /* ��ά�ռ���ֲ���
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
