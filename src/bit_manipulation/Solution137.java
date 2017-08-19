package bit_manipulation;

/* �����������飬����һ��Ԫ��ֻ����һ���⣬����ÿ��Ԫ�ض����������Ρ��ҵ�ֻ����һ�ε��Ǹ���
 * �㷨Ӧ�þ������Ե�ʱ�临���ԡ������ʵ��������ʹ�ö�����ڴ���
 * */

public class Solution137 {
	
	/* ���ü������λ�������ֵ����ԡ�
	 * ���ǿ��Խ���һ��32λ�����֣���ͳ��ÿһλ��1���ֵĸ���������֪�����ĳһλ��Ϊ1�Ļ�����ô������������������Σ���3ȡ��Ϊ0��
	 * ���ǰ�ÿ�����Ķ�Ӧλ����������3ȡ�࣬����ʣ�������Ǹ������ǵ��������֡�
	 * */
	
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
        	int bitCount = 0;
        	for (int num : nums) {
        		bitCount += (num >> i) & 1;
        	}
        	res |= (bitCount % 3) << i;
        }
        return res;
    }
    
    /* ��3����������ʾINT�ĸ�λ�ĳ��ִ��������ones��ʾ������1�Σ�twos��ʾ������2�Ρ�������3�ε�ʱ���λ���㡣���𰸾���ones��ֵ��
     * 1.ones�����iλֻ����һ�ε��������
     * 2.twos�����iλֻ�������ε��������
     * 3.threes�����iλֻ�������ε��������
     * */
    
    /*public int singleNumber(int[] nums) {
    	int ones = 0, twos = 0, threes = 0;
    	for (int i = 0; i < nums.length; i++) {
    		twos |= ones & nums[i];
    		ones ^= nums[i];
    		threes = ones & twos;
    		ones &= ~threes;
    		twos &= ~threes;
    	}
    	return ones;
    }*/
}
