package divide_and_conquer;

import java.util.PriorityQueue;

/* ����δ���������еĵ�k�����Ԫ�ء���ע�⣬��������˳���еĵ�k�����Ԫ�أ������ǵ�k������Ԫ�ء�
 * ���磺
 * ���룺[3,2,1,5,6,4]��k=2
 * �����5
 * */

public class Solution215 {
	
	/* ֱ��ʹ�ö�����
	 * */
	
    /*public int findKthLargest(int[] nums, int k) {
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
    }*/
	
	/* ʹ���޸İ�Ŀ��š�����֪����������Ĺؼ����ǽ�����ֳ������֣�һ��С�ڣ�����ڣ�����ֵ����һ�����ڣ�����ȣ�����
	 * �޸ĺ�İ汾������ֻ�Ե�k��Ԫ�ؽ������� ��������֪����k������Ԫ��Ӧ�ó���������n-k��λ�ã�����n�Ǵ�С��������ÿ��ͨ��ʹ��pivotֵ������ֳ�������ʱ��
	 * ���Ǽ��ÿ�����ֵķ�Χ�� ���n-k���ڷ�Χ�ڣ����ǽ���������
	 * ����Ϊ�����ӽ�����ֳ���������ȳ��ȵĻ��ᣬ����ѡ��nums[mid], nums[start], nums[end]�е��м�����Ϊpivot��
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
	// ÿ��ѡ��a,b,c�м��Ǹ���
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
