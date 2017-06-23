package array;

/* ���⣺
 * ���룺[1,1,0,1,1,1]��ֻ��0��1��ɵ����飩
 * �����3
 * �����������1�ĸ���
 * 
*/

public class Solution485 {
	
	/* ����һ�����飬��һ��������cnt��ͳ��1�ĸ�����
	 * �����������ǰ����Ϊ0����ôcnt����Ϊ0���������0��cnt����1��
	 * Ȼ��ÿ�θ��½��res����
	*/
	
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        int res = 0;
        for (int curNum : nums) {
            cnt = curNum == 0 ? 0 : cnt + 1; 
            //Ҳ���Բ��ó˷�����Ϊֻ��0��1
            //cnt = (curNum + cnt) * curNum;
            res = Math.max(cnt, res);
        } 
        return res;
    }
}
