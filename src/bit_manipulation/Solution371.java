package bit_manipulation;

/* �ڲ�����+��-������¼����������ĺ͡�
 * */

public class Solution371 {
	
	/* �ö�����ʵ�ּӷ����㡣
	 * �ڲ����ǽ�λ������£�a^b������ȷ�������ֻ���λ������£�(a&b)<<1���ǽ����
	 * ��˰���ȫ�����ǽ�λ��ֻ���ǽ�λ������ֵ����Ӿ������յĽ����
	 * */
	
    public int getSum(int a, int b) {
        int sum = a;
        while (b != 0) {
        	sum = a ^ b;
        	b = (a & b) << 1;
        	a = sum;
        }
        return sum;
    }
}
