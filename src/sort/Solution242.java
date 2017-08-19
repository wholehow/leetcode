package sort;

import java.util.Arrays;

/* 给定两个字符串s和t，写一个函数来确定t是否是s的字谜变换。
 * */
public class Solution242 {

	/* 438的超级简化版，用数组模拟HashMap。
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
