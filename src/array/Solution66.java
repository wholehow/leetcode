package array;

/* ���⣺
 * ����һ���Ǹ����Ĵ������ֵ����飬����������֡���һ��
 * ������ֵĴ洢��ʽΪ���λ�������������ǰ�ˡ�
 * 
 * ˵���˾��Ǿ��������ÿһ��λ�ô���һ������ÿһλ���и�λʮλ��λ�ȣ�
 * ��[8]��ʾ����8��[1��2]��ʾ����12�ȵȣ���ĿҪ�󽫸��������ִ��������ּ�һ����ͬ������ʽ���ؽ����
 * */

public class Solution66 {
	
	/* �����Ŀ���ѵ����ڶԼӷ���λ���жϣ�
	 * �Ӹ�λ����ʼ�����+1�����10����ô��Ҫ��λ��
	 * ����λʱҲҪ���϶Ը�λ�����ж��Ƿ�Ҫ��λ����������λͬ�������˽�λ�����鳤�Ȼ�Ҫ����1��ֱ�ӷ���һ���µ����鼴�ɡ�
	 * ����ֻҪ������߼�����������뻹�Ǻ�д�����ġ�
	 * */
	
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}