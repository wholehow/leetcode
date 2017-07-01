package string;

/* ���⣺
 * ����һ���ַ�����һ������k��ÿ2k���ַ���תǰk���ַ���
 * ���ʣ���ַ�����k������ȫ����ת��
 * ���ʣ���ַ���k��2k֮�䣬��תǰk���ַ���ʣ���ַ�����ԭ����
 * */

public class Solution542 {
	
	/* ÿ2k���ַ�������ԭ�ַ���s��Ȼ����з�ת����ת�Ľ�βλ����ȡi+k��ĩβλ��֮��Ľ�Сֵ��
	 * ע��reverse�����±�ļ��㡣
	 * */
    public String reverseStr(String s, int k) {
        if (s == null || s.equals("")) {
			return "";
		}
        char[] ans = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
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
			chs[i] = chs[end - 1 - i + start];	//k=2ʱ��chs[i] = chs[end - 1]
			chs[end - 1 - i + start] = tmp;
		}
	}
}
