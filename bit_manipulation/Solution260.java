package bit_manipulation;

/* ����һ���������ֵ����飬����������Ԫ��ֻ����һ�Σ���������Ԫ�س������Ρ��ҵ�ֻ����һ�ε�����Ԫ�ء�
 * */

public class Solution260 {

	/* ���ֻ��a��b������һ�����඼���������Σ���ô������������Ľ������a^b��
	 * ��Ϊa��b�ǲ�ͬ�ģ�����һ�������ҵ���kλ������a�ĵ�kλΪ0����ôb�ĵ�kλһ����1��
	 * �������ٱ���һ�����飬���ֻ���kλ����1������������������ԡ���ô�ڶ��α��������������
	 * ����a��b�е�һ����������b������a^b���һ�ξ͵õ�a��
	 * */
	
	public int[] singleNumber(int[] nums) {
	    int[] res = new int[2];        
	    int xor = 0;
	    for (int num : nums)
	    {
	        xor ^= num;
	    }
	    int rightMost = xor & ~(xor - 1);	// Ѱ�����Ҳ��1
	    // int bit = xor & (~xor + 1);
	    int num1 = 0, num2 = 0;
	    for (int num : nums)
	    {
	        if ((num & rightMost) > 0)
	        {
	            num1 ^= num;
	        } else
	        {
	            num2 ^= num;
	        }
	    }
	    res[0] = num1;
	    res[1] = num2;
	    return res;
	}
}
