package string;

/* ���⣺
 * �����ַ����еķǿ��Ӵ��ĸ�����
 * 
 * ���磺
 * ���룺"Hello, my name is John"
 * �����5
 * */

public class Solution434 {
	
	/* ͵���Ļ���ֱ��ʹ��split������
	 * �������ﻹ�����ͳ��ɨ�跨��
	 * */
	
    public int countSegments(String s) {
        if (s == null || s.equals(" ")) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                cnt++;
            }
        }
        return cnt;
    }
}
