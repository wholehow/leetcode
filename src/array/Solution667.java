package array;

/* ��������n��k������[a1, a2, a3, ... , an] = [1, 2, 3, ..., n]���������У�
 * ʹ������[|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] ǡ�ð���k����ͬ������
 * */

public class Solution667 {
	
	/* ��������1,2,3...n�����ǽ����������1,n,2,n-1...
	 * */
	
    public int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        int lower = 1;
        int higher = n;
        int idx = 0;
        while (k--!=0) {
        	//nums[idx++] = idx % 2 == 0 ? lower++ : higher--;
        	if (idx % 2 == 0) {	//ż��λ������ԭ������1,x,2,x...
        		nums[idx] = lower;
        		lower++;
        	} else {
        		nums[idx] = higher;	//����λ����Ϊn,x,n-1,x...
        		higher--;
        	}
        		idx++;
        	}
        //�Ѿ��õ�����Ҫ��K����������Ҫ����ʣ�µ�n-2k����
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
