package hash_table;

import java.util.HashSet;
import java.util.Set;

/* ����һ����Сд���д��ĸ��ɵ��ַ������ҵ���������Щ��ĸ��������Ļ��ĳ��ȡ�
 * ���磺
 * ���룺"abccccdd"
 * �����7�����Խ������Ļ����ǡ�dccaccd��������Ϊ7�� 
 * */

public class Solution409 {
	
	/* ����set�����ʣ����������ַ��������set�Ĵ�СΪ0��˵��ԭ�����ַ���һ���������幹��һ�����ģ�
	 * ������Ļ��ľ����ַ����ĳ��ȼ�ȥset�Ĵ�С��
	 * */
	
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        Set<Character> set = new HashSet<>();
        for (char letter : s.toCharArray()) {
        	// ����Ѿ����ھ����߶�ɾ������Ϊ����һ���������һ������
        	if (set.contains(letter)) {
        		set.remove(letter);
        	} else {
        		set.add(letter);
        	}
        }
        int size = set.size();
        // ΪʲôҪ��1�����ֻʣ��һ����������Ҳһ����һ�����ġ�����abccb���������5��
        return s.length() - (size == 0 ? 0 : size - 1);
    }
}
