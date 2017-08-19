package array;

/* ���⣺
 * ����Ƕ�ס�
 * ������N����ͬ������ɵ�����������A�����������[0��N-1]��Χ�ڵ�����������
 * ����0 <= K < N��S[K]�������£�
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }
 * ����S[K]����ÿ��K�����޵ģ���Ӧ�����ظ��
 * дһ��������N��������ɵ�����A�ĺ��������ظ��������󼯺�S[K]�Ĵ�С��
 * ���磺
 * ���룺A = [5,4,0,3,1,6,2]
 * �����4��A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2��
 * �������S [K]��S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * */

public class Solution565 {
	
	/* �ø���������������ģ��ᷢ�����Ľ�����Ͻ��������бհ��ĸ������������ѭ���ģ�ֻҪ�ҵ������������һ��������
	 * �ҵ������κεġ�
	 * ������ģ��DFS�Ĺ��̡�ѧ����˼·���ø��ű�������ѱ����ʹ�������
	 * */
	
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] >= 0) {
        		int len = 1, curVal = nums[i];	// ����0����δ�����ʹ�
        		while (Math.abs(curVal) != i) {	// ����S��һ����
        			len++;
        			curVal = nums[Math.abs(curVal)];
        			if (nums[Math.abs(curVal)] > 0) {
        				nums[Math.abs(curVal)] *= -1;
        			}
        		}
            	rst = Math.max(len, rst);
        	}
        }
        return rst;
    }
}
