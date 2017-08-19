package hash_table;

import java.util.HashMap;

/* ���⣺
 * ����һ��ģ�ͺ�һ���ַ������ж��ַ����Ƿ���ѭģ�͡�
 * �������ѭ��ָȫƥ�䣬ģ���е�ÿ����ĸ��ӳ���ַ����еķǿյ��ʡ�
 * ���ӣ�
 * 1.pattern = "abba", str = "dog cat cat dog" Ӧ�÷��� true��
 * 2.pattern = "abba", str = "dog cat cat fish" Ӧ�÷��� false��
 * 3.pattern = "aaaa", str = "dog cat cat dog" Ӧ�÷��� false��
 * 4.pattern = "abba", str = "dog dog dog dog" Ӧ�÷��� false��
 * ע�⣺ ����Լ���ģ��ֻ����Сд��ĸ�������ַ��������ɿո�ֿ���Сд��ĸ���ʡ�
 * */

public class Solution290 {
	
	/* ����HashMap��key+value����ϡ�
	 * ��ÿ����ĸӳ�䵽һ�����ʣ�������1��a��Ӧdog��b��Ӧcat���ж���������֪a�ж�word�Ƿ�Ϊdog����֪����cat�ж�
	 * ��key�Ƿ��Ѿ����ڲ��Ҳ���a��
	 * */
	
    public boolean wordPattern(String pattern, String str) {
    	String[] words = str.split(" ");
    	if (words.length != pattern.length()) {
    		return false;
    	}
    	HashMap<Character, String> map = new HashMap<Character, String>();
    	for (int i = 0; i < pattern.length(); i++) {
    		if (map.containsKey(pattern.charAt(i))) {
    			// map��Ӧ������a��dog����ϣ�����a�����ܶ�Ӧcat
    			if (!map.get(pattern.charAt(i)).equals(words[i])) {
    				return false;
    			}
    		} else {
    			// ����map��a��dog����ϣ�ѡ��wordΪcat��Ӧ����Ȼ��a
    			if (map.containsValue(words[i])) {
    				return false;
    			}
    			map.put(pattern.charAt(i), words[i]);
    		}
    	}
    	return true;
    }
}
