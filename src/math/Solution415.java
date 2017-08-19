package math;

/* ���⣺
 * ���������ַ�����ʽ�ķǸ���num1��num2������num1��num2֮�͡�
 * ע�⣺
 * 1.num1��num2�ĳ��ȶ�С��5100��
 * 2.num1��num2��ֻ��������0-9��
 * 3.num1��num2��������������λ��0�� 
 * 4.�㲻��ʹ���κ����õĴ��������ֱ�ӽ�����ת�������͡�
 * */

public class Solution415 {
	
	/* �������ַ�������ĩβ��ʼȥ�ӣ�ע���ж��Ƿ�Ҫ��λ��һλλ�ӵ������ַ�����������Ϊֹ��
	 * Ϊ���ٶ�����Ҫʹ��StringBuilder�����ֱ���� + ȥ�����ַ�ƴ�Ӿ�̫���ˣ�ע������ÿ�ζ�ÿλ�����м�ʱ���������������㡣
	 * */
	
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
        	return num1.length() == 0 ? num2 : num1;
        }
        boolean hasUp = false;	//�Ƿ��λ
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sBuilder = new StringBuilder();
        while (i >=0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + (hasUp ? 1 : 0);
            if (sum >= 10) {
                sBuilder.insert(0, Integer.toString(sum - 10));
                hasUp = true;
            } else {
                sBuilder.insert(0, Integer.toString(sum));
                hasUp = false;
            }
            i--;
            j--;
        }
        if (hasUp) {
        	sBuilder.insert(0, "1");
        }
        return sBuilder.toString();
    }
}
