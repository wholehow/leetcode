package dp;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/* ���������˻���
 * �ҵ������а�������������˻������ٰ���һ�����֣���
 * */

public class Solution152 {
	
	/* �е�����Ѱ�������г˻�����������/�ĸ�����
	 * ����curMax��curMin�ֱ����ǰ���˻�����С�˻�����Ϊ�����п����и�����������һ�����˻�һ����
	 * ��һ�����/��С�˻��뵱ǰ���ĳ˻��͵�ǰ���нϴ��ߡ�
	 * */
	
    public int maxProduct(int[] nums) {
    	// pre���ڱ��浱ǰ�ν����Ϊ��һ�β���Ƚ�
        int curMaxPre = nums[0], curMinPre = nums[0];
        int rst = nums[0];	// �������ս��
        int curMax, curMin;
        for (int i = 1; i < nums.length; i++) {
        	curMax = Math.max(Math.max(curMaxPre * nums[i], curMinPre * nums[i]), nums[i]);
        	curMin = Math.min(Math.min(curMaxPre * nums[i], curMinPre * nums[i]), nums[i]);
        	rst = Math.max(curMax, rst);	// ע�����ﲻҪд��curMax��curMin�еĽϴ���
        	curMaxPre = curMax;
        	curMinPre = curMin;
        }
        return rst;
    }
}
