package heap;

import java.util.PriorityQueue;

/* 查找未排序数组中的第k个最大元素。请注意，它是排序顺序中的第k个最大元素，而不是第k个独特元素。
 * 例如：
 * 输入：[3,2,1,5,6,4]，k=2
 * 输出：5
 * */

public class Solution215 {
	
	/* 直接使用堆排序。
	 * */
	
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
        	return 0;
        }
        // 优先级队列实现的heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1);
        for (int num : nums) {
        	pq.offer(num);
        	if (pq.size() > k)	// 保证大小只为k，并且这k个值一定是nums中最大的k个值
        		pq.poll();
        }
        return pq.poll();
        // return pq.peek();
    }
}
