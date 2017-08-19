package sort;

import java.util.Arrays;

/* ���������ַ���s��t��дһ��������ȷ��t�Ƿ���s�����ձ任��
 * */
public class Solution242 {

	/* 438�ĳ����򻯰棬������ģ��HashMap��
	 * */
	
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
        	return false;
        }
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
        	alphabets[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
        	alphabets[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alphabets.length; i++)  {
        	if (alphabets[i] != 0) {
        		return false;
        	}
        }
        return true;
    }*/
	
	public boolean isAnagram(String s, String t) 
	{
	    char[] sChar = s.toCharArray();
	    char[] tChar = t.toCharArray();
	    
	    Arrays.sort(sChar);
	    Arrays.sort(tChar);
	    
	    return Arrays.equals(sChar, tChar);   
	}
}
