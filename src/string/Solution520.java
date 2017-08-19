package string;

/* ���⣺
 * �жϵ����Ƿ�Ϊ����ĸ��д��ȫ����д����ȫ��Сд��
 * */

public class Solution520 {
	
	/* ������������һ�����ʣ������Ǽ���д��ʽ�Ƿ���ȷ�������Լٶ�ȷʵֻ������ĸ��
	 * ��ô����Ҫ���ľ���ͳ�Ƴ����������д�д��ĸ�ĸ���cnt�������ж��Ƿ����������������
	 * ���cntΪ0��˵������Сд����ȷ��
	 * ���cnt�͵��ʳ�����ȣ�˵�����Ǵ�д����ȷ��
	 * ���cntΪ1��������ĸΪ��д����ȷ���������������false
	 * */
	
    public boolean detectCapitalUse(String word) {
        if (word == null || word.equals("")) {
        	return false;
        }
        int cnt = 0;
        for (Character c : word.toCharArray()) {
        	if (c <= 'Z') {
        		cnt++;
        	}
        }
        return cnt == 0 || cnt == word.length() || (cnt == 1 && word.charAt(0) <= 'Z');
    }
}
