package greedy;

/* ����һ���Ǹ��������顣�����е�ÿ��Ԫ�ش������ڸ�λ�õ������Ծ���롣ȷ�����Ƿ��ܹ��ﵽ���һ��������
 * ���磺
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * */

public class Solution55 {
	
	/* ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(1)��
	 * */
	
	public boolean canJump(int[] nums) {
	    int maxReach = 0;	// ��Զ�ܵ����λ��
	    for (int i = 0; i <= maxReach; i++) {	// �����;�Ѿ�֪�����ǿ��Ե��������ô�Ͳ���ɨ����������
	        maxReach = Math.max(maxReach, i + nums[i]);
	        if (maxReach >= nums.length - 1) {
	            return true;
	        }
	    }
	    return false;
	}
}
