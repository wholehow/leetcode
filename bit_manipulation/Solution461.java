package bit_manipulation;

/* ���⣺
 * ������������x��y��������֮��ĺ������롣
 * ����������ָx��y��Ӧ�Ķ�������ͬ��λȡֵ����ͬ����λ����
 * */

public class Solution461 {
	
	/* �ӵ�λ���λ�Ƚϡ����x��y�����λ����ͬ��Ҳ����˵x��y����ͬ��Ҳ����˵x��y��2ȡ�����϶���ͬ��
	 * �Դ����ƣ������λ��
	 * */
	
    public int hammingDistance(int x, int y) {
        int rst = 0;
        while (x != 0 || y != 0) {
        	if (x % 2 != y % 2) {
        		rst++;
        	}
        	x >>>= 1;
        	y >>>= 1;
        }
        return rst;
    }
}
