package dp;

/* ���⣺
 * ����һ���������� nums��Ѱ������λ�� i �� j ֮��Ԫ�صĺͣ����� i �� j Ԫ�ء�
 * 
 * ���磺
 * ����nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * */

public class Solution303 {
	
	/* �������ʵ���ǿ�ĳ���㷨�����ǿ�ʵ�ֵķ�ʽ��
	 * ��dp[i]���洢0��i֮��Ԫ�صĺͣ�0��j�ĺͼ�ȥ0��i-1�ĺͼ�Ϊ����
	 * */
	
    private int[] dp;
    public Solution303(int[] nums) {
        dp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
