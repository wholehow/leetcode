package math;

/* �ж�һ�����Ƿ�����ȫƽ��������c = a^2 + b^2��
 * */

public class Solution633 {
	
	/* ��򵥵ķ������Ƕ���a,b��0 < a, b <= c���������ж�c = a^2 + b^2�ǹ�������������ʱ�临�Ӷ�ΪO(N^2)���ᳬʱ��
	 * ����c = a^2 + b^2������ֻ��Ҫ��0��sqrt(c)���������c-i*i��ʣ��ֵ��
	 * ��������п������������������ƽ�����ڿ���ǰ�������Ϊtrue��
	 * ��Ϊsqrt()������������λ�����Բ��ܿ����������ֻ������λ���˷���ȥ��Ȼ�����ڿ���ǰ����
	 * */
	
    public boolean judgeSquareSum(long c) {  
    	if (c == 0) {
    		return true;
    	}
        for(long i = 0; i * i <= c; i++){  
            long rem = c - i * i;  
            long r = (long)Math.sqrt(rem);  
            if (rem == r * r) {
            	return true;  
            }
        }  
        return false;  
    }  
}
