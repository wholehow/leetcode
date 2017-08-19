package array;

/* ���⣺
 * ����һ������n�����ֵ����飬���ַ�ΧΪ 0, 1, 2, ..., n��Ѱ��������ʧ���Ǹ����֡�
 * ���ӣ� ���� nums = [0, 1, 3] ���� 2��
 * ע�⣺ ����㷨��Ҫ������ʱ�临�Ӷ������С��ܲ���ʹ�ú㶨�Ķ���ռ临�Ӷȣ�
 * */

public class Solution268 {
	
	/* һ��˼·�����õȲ��������0-N��Ȼ�����nums����ĺͣ����������Ϊ��ʧ���Ǹ����֡�
	 * ����Ҫ���⿼�ǵ�0��
	 * ���Ǹ��õİ취�����������������ʡ�
	 * */
	
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int xor = 0;
        int i = 0;
	    for (; i < nums.length; i++) {
		    xor = xor ^ i ^ nums[i];
	    }
	    return xor ^ i;
    }
}
