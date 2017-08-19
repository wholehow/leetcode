package string;

/* ��������Ӵ�
 * ����һ���ַ�������������Ǽ�������ַ������ж��ٸ��������ַ�����
 * ���в�ͬ��ʼ������������������ַ���������Ϊ��ͬ�����ַ�������ʹ��������ͬ���ַ���ɡ�
 * ���磺
 * ���룺"abc"
 * �����3�����������ַ�������a������b������c����
 * ���룺"aaa"
 * �����6�����������ַ�������a������a������a������aa������aa������aaa����
 * */

public class Solution647 {
	
	/* ʹ��count��Ϊȫ�ֱ�����¼�������
	 * ���в�ͬ��ʼ������������������ַ���������Ϊ��ͬ�����ַ����������õķ�ʽ���Ƕ���λ��i�ϵ��ַ�������ÿ�δӸ�λ������������жϣ�
	 * ��checkPalindrome��������Ҫ���i����������ż�����ȵĻ���������
	 * */
	
	private int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        for (int i = 0; i < s.length(); i++) {
        	checkPalindrome(s, i, i);	// ����������Ȼ����Ӵ��Ļ���
        	checkPalindrome(s, i, i + 1);	// ���ż�����Ȼ����Ӵ��Ļ���
        }
        return count;
    }
    // ����޶����Ȼ����Ӵ��Ļ���
    private void checkPalindrome(String s, int left, int right) {
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		count++;
    		left--;
    		right++;
    	}
    }
}
