package dp;

/* ���⣺
 * ����һ��רҵ�ĵ������ƻ�͵һ�����ϵ���
 * ÿƥ��������ȷ�����Ľ�Ǯ��Ψһ��ֹ��͵�������ԭ�������ڵ��������˰�ȫϵͳ��������ڵ���ƥ����ͬһ��ҹ�ﱻ͵�߾ͻ��Զ���ϵ���졣
 * ����һ������ÿ�����ӵķǸ��������б�ȷ����������Ͽ���͵�Ե������������Ѿ��졣
 * */

public class Solution198 {
	
	/* �����ı����൱����һ��������ȡ��һ����������������ʹ������
	 * ����ά��һ��һά����dp������dp[i]��ʾ��iλ��ʱ�����������γɵ����͡�
	 * ���ڲ��������ڵģ��������ǿ�������ǰ���һ����dpֵ���ϵ�ǰ�ķ���ֵ���͵�ǰ�����ǰ��һ��dpֵ�Ƚϣ�ȡ�ϴ�ֵ������ǰdpֵ��
	 * dp[i] = Math.max(num[i - 1] + dp[i - 2], dp[i - 1])
	 * */
	
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        if (nums.length == 1) {
        	return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        	//Ҳ����ʹ����ż
        	//dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1];
        }
        return dp[nums.length];
    }
    
    /* ����Ϊ������ֻ��Ҫdp[n]��������Ҫ�������dp���飬��ô���Ը��´��룬���Ϳռ临�Ӷȡ�
     * */
    
    /*public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        if (nums.length == 1) {
        	return nums[0];
        }
        int last = 0;
        int now = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = last;
            last = now;
            now = Math.max(temp + nums[i], last);
        }
        return now;
    }*/
}
