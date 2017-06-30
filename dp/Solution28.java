package string;

/* ���⣺
 * ʵ�� strStr()��
 * ���� haystack �е�һ�γ��� needle ��λ�ã���� needle ���� haystack ��һ�����򷵻� -1��
 * */

public class Solution28 {
	
	/* ��򵥵��������Ǳ��� haystack �����ֺ� needle ��һ���ַ���ͬ��Ԫ�أ��Ϳ�ʼ����Ƚϣ�
	 * ���ȫ�����귢��һ������ô����֮ǰ�Ǹ���ʼλ�þͿ����ˣ�
	 * �����;�в�һ���ģ���ô��Ҫ��֮ǰ��λ�õ���һ��λ�ÿ�ʼ��������Ѱ�ҡ�
	 * */
	
    /*public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
        	return 0;
        }
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        int i = 0;
        int j = 0;
        for (; i < haystackArr.length;i++) {
            if (haystackArr[i] == needleArr[j]) {
                for (int k = i; k < haystackArr.length && j < needleArr.length; k++, j++) {
                    if (haystackArr[k] != needleArr[j]) break;
                }
                if (j == needleArr.length) return i;
                else j = 0;
            }
        }
        return -1;
    }*/
	
	/* ���ǿ��Զ�����Ĵ���ѭ�����ֽ��б��Σ���dis��¼�����ַ����ĳ��Ȳ
	 * ����˼����ʹ��subString������
	 * */
	
	 public int strStr(String haystack, String needle) {
		 int len1 = haystack.length();
		 int len2 = needle.length();
		 if (len1 < len2) {
			return -1;
		 } else if (len2 == 0) {
			return 0;
		 }
		 int dis = len1 - len2;
		 for (int i = 0; i < dis; i++) {
			 if (haystack.substring(i, i + dis).equals(needle)) {
				 	return i;		
			}
		 }
		 return -1;
	 }
}
