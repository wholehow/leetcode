package string;

/* ���⣺
 * ����һ���ɴ�Сд��ĸ�Ϳո���ɵ��ַ���s�����������һ�����ʵĳ��ȡ�
 * ������һ�����ʲ����ڣ�����0��
 * ע�⣺������ָ���зǿո��ַ���ɵ����С�
 * 
 * ���磺 ���� s = "Hello World", ���� 5��
 * */

public class Solution58 {
	
	/* �Ӻ���ǰ�����ַ��������ĩβ����пո��Ȱѿո�ȥ���ɾ���
	 * Ȼ��ȡ��ĸ�ĳ��ȣ��ٴ������ո��ֹ����Ϊ�ǴӺ���ǰ����������Ҫȫ�������������ַ��������Ի�ȴ�ǰ����졣
	 * */
	
    public int lengthOfLastWord(String s) {
        if (s == null || s.equals(" ")) {
            return 0;
        }
        int i = s.length() - 1;
        int spaces = 0;	//ͳ�ƿ��ܴ��ڿո����Ŀ
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
            spaces++;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return s.length() - spaces - (i + 1);
    }
    
    /* ��Ȼ��͵���ķ�������split������
     * */
    
    /*public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if(strs == null || strs.length == 0)
            return 0;

        return strs[strs.length - 1].length();
    }*/
}
