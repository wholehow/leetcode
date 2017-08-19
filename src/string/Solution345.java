package string;

/* ���⣺
 * дһ������������һ���ַ���Ȼ��ת�����Ԫ����ĸ��
 * ��1�� ���� s = "hello"������"holle"��
 * ��2�� ���� s = "leetcode"������"leotcede"��
 * ע�⣺ Ԫ����������ĸ��y����
 * */

public class Solution345 {
	
	/* ˫ָ�뷨��
	 * ���ַ�����ͷ��β����һ��ָ����б������������м䣬�����˶�����Ԫ����ĸ�󣬾ͶԻ���
	 * ֱ������ָ����ͷΪֹ��
	 * */
	
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chs = s.toCharArray();
        while (left < right) {
            if (isVowel(chs[left]) && isVowel(chs[right])) {
                swap(chs, left++, right--);
            } else if (isVowel(chs[left])) {
                right--;
            } else {
                left++;
            }
        }
        return new String(chs);
    }
    private boolean isVowel (char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' 
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
