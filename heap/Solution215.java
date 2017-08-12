package heap;

import java.util.PriorityQueue;

/* ����δ���������еĵ�k�����Ԫ�ء���ע�⣬��������˳���еĵ�k�����Ԫ�أ������ǵ�k������Ԫ�ء�
 * ���磺
 * ���룺[3,2,1,5,6,4]��k=2
 * �����5
 * */

public class Solution215 {
	
	/* ֱ��ʹ�ö�����
	 * */
	
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
        	return 0;
        }
        // ���ȼ�����ʵ�ֵ�heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1);
        for (int num : nums) {
        	pq.offer(num);
        	if (pq.size() > k)	// ��֤��СֻΪk��������k��ֵһ����nums������k��ֵ
        		pq.poll();
        }
        return pq.poll();
        // return pq.peek();
    }
}
