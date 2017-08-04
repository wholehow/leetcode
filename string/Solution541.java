package string;

/* ���⣺
 * ����һ���ַ�����һ������k������Ҫ���ַ�����ͷ��ÿ2k���ַ��ķ�תǰk���ַ������ʣ�µ��ַ�����k���ַ�����ת�����ַ���
 * ���С��2k�����ڻ����k���ַ�����תǰk���ַ�������һ����Ϊԭʼ�ַ���
 * ���磺
 * ���룺 s = "abcdefg", k = 2
 * �����"bacdfeg"
 * */

public class Solution541 {
	
	/* reverse����������תÿ2k���ַ���ǰk���ַ���
	 * */
	
    public String reverseStr(String s, int k) {
        if (s == null || s.equals("")) {
			return "";
		}
        char[] ans = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
        	// ����k����ֱ�ӷ�תʣ�µ�
        	if (s.length() - i < k) {
        		reverse(ans, i, s.length());
        	} else {
        		reverse(ans, i, i + k);
        	}
        }
        return new String(ans);
    }
	private void reverse(char[] chs, int start, int end) {
		for (int i = start; i < (start + end) / 2; i++) {
			char tmp = chs[i];
			chs[i] = chs[end - 1 - i + start];
			chs[end - 1 - i + start] = tmp;
		}
	}
}
