package array;

/* 给定整数n和k，数组[a1, a2, a3, ... , an] = [1, 2, 3, ..., n]，重新排列，
 * 使得数组[|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 恰好包含k个不同整数。
 * */

public class Solution667 {
	
	/* 对于数组1,2,3...n，我们将它变成这样1,n,2,n-1...
	 * */
	
    public int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        int lower = 1;
        int higher = n;
        int idx = 0;
        while (k--!=0) {
        	//nums[idx++] = idx % 2 == 0 ? lower++ : higher--;
        	if (idx % 2 == 0) {	//偶数位，还是原来的数1,x,2,x...
        		nums[idx] = lower;
        		lower++;
        	} else {
        		nums[idx] = higher;	//奇数位，变为n,x,n-1,x...
        		higher--;
        	}
        		idx++;
        	}
        //已经得到了需要的K个数，还需要处理剩下的n-2k个数
        	if (idx % 2 == 1) {
        		while (idx < n) {
        			nums[idx++] = lower++;
        		}
        	} else {
        		while (idx < n) {
        			nums[idx++] = higher--;
        		}
        	}
        return nums;
    }
}
