package string;

/* ���⣺
 * �����ַ�������ÿ���������ַ����ã��������ַ�����
 * ע�⣺�ַ����е���֮������ֻ��1���ո�ֿ���
 * 
 * ���磺
 * ���룺"Let's take LeetCode contest"
 * �����"s'teL ekat edoCteeL tsetnoc"��
 * */

public class Solution557 {
	
	/* �ÿո�ָ��ַ�������ÿ���Ӵ���������ӵ�������顣
	 * */
	
    public String reverseWords(String s) {  
        String[] strs = s.split(" ");  
        String resStr = "";  
        for (int i = 0; i < strs.length - 1; i++) {  //�����������һ������
            resStr += reverse(strs[i]) + " ";  
        }
        resStr += reverse(strs[strs.length - 1]);	
        return resStr;  
    }  
    public String reverse(String str) {  
        String result = "";  
        for (int i= str.length() - 1; i >= 0; i--)   
            result += str.charAt(i);  
        return result;  
    }  
}
