package math;

/* ���⣺
 * �������������� 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... ���ҵ���n�����֡�
 * ע�⣺ n�Ǹ��������һ���32λ��Χ�ڣ�n<2��31�η�����
 * 
 * ���磺
 * ���룺3 
 * �����3
 * 
 * ���룺11 
 * �����0 ���ͣ����� 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... �ĵ�11����������10�е�0��
 * */

public class Solution400 {
	
	/* ����������������Ȼ�����к���λ���Ĺ�ϵ��
	 * ǰ9��������1λ�ģ�Ȼ��10��99�ܹ�90�����ֶ�����λ�ģ�100��999��900����������λ�ġ�
	 * ��ô��ͺ��й����ˣ����ǿ��Զ��������cnt����ʼ��Ϊ9��Ȼ��ÿ��ѭ������10����
	 * ����һ������len��¼��ǰѭ���������ֵ�λ����
	 * ��������Ҫһ������start������¼��ǰѭ������ĵ�һ�����֣�
	 * ����nÿ��ѭ������ȥlen*cnt (������λ��)����n�䵽ĳһ��ȷ�����������ˣ�
	 * ��ô(n-1)/len����Ŀ�������ڸ�����������꣬����start���ǵõ���Ŀ�����֣�
	 * Ȼ�����ǽ�Ŀ������startתΪ�ַ�����(n-1) % len������Ҫ���Ŀ��λ
	 * */
	
    public int findNthDigit(int n) {
    	long cnt = 9;	//���������ʹ��long������ᷢ��Խ���
    	int len = 1;
    	int start = 1;
        while (n > len * cnt) {
            n -= len * cnt;
            len++;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }  
}