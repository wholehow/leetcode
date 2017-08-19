package array;

/* ���⣺
 * ��С�ߴ�������ĺ�
 * ����n����������һ�������������飬�ҵ��ܺ͡�s�����������е���С���ȡ����û�У�����0��
 * ���磺
 * ���룺[2,3,1,2,4,3],s = 7
 * �����[4,3]
 * */

public class Solution209 {
	
	/* �������Ľ���������飬������Ҫ��¼��߽磬���ʹ��˫ָ�뷨��⡣
	 * i��j��Ϊ������Ҫʹ�õ�˫ָ�롣
	 * i�ƶ��������ǵ�ǰ�ʹ���s��j�ƶ��������ĵ�ǰ��С��s��
	 * */
	
    public int minSubArrayLen(int s, int[] nums) {
    	if (s < 0 || nums == null) {
    		return 0;
    	}
    	int i = 0, j = 0, sum = 0, minLen = Integer.MAX_VALUE;
    	// �ұ߽���Ϊ�ж�ѭ������������
    	while (j < nums.length) {
    		sum += nums[j++];
    		// һ������sum>=s��˵����ǰ��߽��Ѿ���������
    		while (sum >= s) {
    			minLen = Math.min(minLen, j - i);
    			sum -= nums[i++];
    		}
    	}
    	return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    /* ���ֲ��ҡ�
     * ���ǹ���һ��sum���飬�䱣���Ԫ����nums[0..n]�ĺ͡�
     * ������Ҫ�Ĳ����������ö��ֲ��ҷ���sum�������ҵ���Ϊs���Ǹ��ҽ�ֵ��
     * */
    
    /*public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;

        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);

        for (int i = 0; i < nums.length; i++) {
            int j = findWindowEnd(i, sums, s);
            if (j == nums.length) break;
            min = Math.min(j - i + 1, min);
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int findWindowEnd(int start, int[] sums, int s) {
        int i = start, j = sums.length - 1, offset = start == 0 ? 0 : sums[start - 1];
        while (i <= j) {
            int m = (i + j) / 2;
            int sum = sums[m] - offset;
        if (sum >= s) {
        	j = m - 1;
        } else {
        	i = m + 1;
        }
        }
        return i;
    }*/
}
