package string;

/* ���⣺
 * ����һ���ǿ��ַ�����������Ƿ�������������ַ����ظ���ɡ�
 * ����Լ���������ַ���ȫ����Сд��ĸ��ɲ������ĳ��Ȳ�����10000��
 * ���磺
 * ���룺��abab�� �����True ���ͣ��ظ��������ַ��� ��ab����
 * ���룺��aba�� �����False
 * ���룺��abcabcabc�� �����True ���ͣ�����ظ����ַ��� ��abc�����������ظ��������ַ��� ��abcabc������
 * */

public class Solution459 {
	
    /* Ҫ�ж�һ���ַ����Ƿ��������ĳ���Ӵ������ظ����õ�����ֱ�ӵķ��������ҳ����е��Ӵ���Ȼ���ж�����Ӵ��Ƿ����ƴ�Ӵ����յ��ַ�����
     * ģ�ⲻ��ƴ���ַ������жϡ�
     * �����Ӵ������ϵļ�֦��
     * */
	public boolean repeatedSubstringPattern(String str) {
	    for (int i = 1; i <= str.length() / 2; i++) {
	        if (str.length() % i != 0) {
	            continue;
	        }
	        String pattern = str.substring(0, i);
	        int start = i;
	        while (start != str.length()) {
	            if (!str.startsWith(pattern, start)) {	//�·�����ʹ��
	                break;
	            }
	            start += pattern.length();
	        }
	        if (start == str.length()) {
	            return true;
	        } 
	    }
	    return false;
	}
	
    /* ��ʵ����һ�ָ�ţ��˼·��
     * �����ַ����ĵ�һ���ַ������ظ����ַ����ĵ�һ���ַ�
     * �����ַ��������һ���ַ������ظ����ַ��������һ���ַ�
     * ��S1 = S + S�����������ַ����е�S��
     * ɾ��S1�ĵ�һ�������һ���ַ��������ַ���S2��
     * ���S������S2�У��򷵻�true����Ϊfalse��
     * */
}	
