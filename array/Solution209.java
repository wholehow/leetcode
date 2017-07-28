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
}
