package bit_manipulation;

/* ���⣺
 * �����������У�ÿ��Ԫ�ؾ��������Σ�����һ��Ԫ�����⣬����ҳ����Ԫ�أ��ܷ����һ������ʱ����㷨���Ҳ���Ҫ����Ĵ洢�ռ䣿
 * */

public class Solution136 {
	
	/* λ������ô�ٵ���������
	 * */
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
