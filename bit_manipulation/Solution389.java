package bit_manipulation;

/* ���⣺
 * ��������ֻ��Сд��ĸ��ɵ��ַ���s��t��
 * �ַ���t���ַ���s����˳���Ҷ��������λ�����һ����ĸ��ɡ�
 * Ѱ��t���������Ǹ���ĸ��
 * */

public class Solution389 {
	
	/* ��136��;ͬ�飬�������������������ʡ�
	 * ��Ϊs��tֻ��һ���ַ���ͬ�����仰˵��ÿ����s�г��ֵ��ַ�����t�г��ֹ���
	 * */
	
    public char findTheDifference(String s, String t) {
        char ans = 0;
        for (int i = 0; i < s.length(); i++) {
        	ans ^= s.charAt(i);
        }
        for (int j = 0; j < t.length(); j++) {
        	ans ^= t.charAt(j);
        }
        return ans;
    }
}
