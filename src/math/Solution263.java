package math;

/* ���⣺
 * дһ���������������������Ƿ���һ��������
 * ������ָֻ�ܱ�2��3��5����������������˵��6��8�ǳ�����14�Ͳ��ǳ�����Ϊ������7���Լ���� 
 * ע��1Ҳ�������ɳ����֡�
 * */

public class Solution263 {
	
	/* �ֱ��2��3��5ȥ���ܲ��ܱ��������ܾͳ�һ�¼����жϣ�ֱ�����ܱ�2��3��5������Ϊֹ��
	 * ������ǲ���1���ǵĻ����ǳ����ˣ������򲻳�
	 * */
	
    public boolean isUgly(int num) {
        if (num <= 0) {
        	return false;
        }
        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else if (num == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
