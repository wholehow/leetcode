package divide_and_conquer;

import java.util.PriorityQueue;

/* 查找未排序数组中的第k个最大元素。请注意，它是排序顺序中的第k个最大元素，而不是第k个独特元素。
 * 例如：
 * 输入：[3,2,1,5,6,4]，k=2
 * 输出：5
 * */

public class Solution215 {
	
	/* 直接使用堆排序。
	 * */
	
    /*public int findKthLargest(int[] nums, int k) {
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
    }*/
	
	/* 使用修改版的快排。我们知道快速排序的关键点是将数组分成两部分，一个小于（或等于）该数值，另一个大于（或相等））。
	 * 修改后的版本是我们只对第k个元素进行排序。 假设我们知道第k个最大的元素应该出现在数组n-k的位置（其中n是大小），并且每次通过使用pivot值将数组分成两部分时，
	 * 我们检查每个部分的范围， 如果n-k不在范围内，我们将不会排序。
	 * 并且为了增加将数组分成两部分相等长度的机会，我们选则nums[mid], nums[start], nums[end]中的中间数作为pivot。
	 * */
	
	public int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		int target = n - k;
		quicksort(nums, 0, n-1, target);
		return nums[n-k];
	}
	private void quicksort(int[] nums, int start, int end, int target){
	    if(start >= end){
	        return;
	    }
	    int mid = start + (end - start)/2;
	    int pivot = choosePivot(nums[mid], nums[start], nums[end]);
	    //int pivot = nums[mid];
	    int i = start;
	    int j = end;
	    while(i <= j){
	        while(nums[i] < pivot){
	            i++;
	        }
	        while(nums[j] > pivot){
	            j--;
	        }
	        if(i <= j){
	            if(nums[i] != nums[j]){
	                swap(nums, i, j);
	            }
	            i++;
	            j--;
	        }
	    }
	    if(target <= i - 1){
	        quicksort(nums, start, i - 1, target);
	    }
	    else{
	        quicksort(nums, i, end, target);
	    }
	}
	// 每次选择a,b,c中间那个数
	private int choosePivot(int a, int b, int c){
		if ((a >= b && b >= c) || (c >= b && b >= a)) return b;
		else if ((b >=a && a >= c) || (c >= a && a >= b)) return a;
		else return c;
	}
	private void swap(int[] nums, int i, int j){
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}
}
