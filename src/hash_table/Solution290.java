package hash_table;

import java.util.HashMap;

/* 大意：
 * 给出一个模型和一个字符串，判断字符串是否遵循模型。
 * 这里的遵循是指全匹配，模型中的每个字母都映射字符串中的非空单词。
 * 例子：
 * 1.pattern = "abba", str = "dog cat cat dog" 应该返回 true。
 * 2.pattern = "abba", str = "dog cat cat fish" 应该返回 false。
 * 3.pattern = "aaaa", str = "dog cat cat dog" 应该返回 false。
 * 4.pattern = "abba", str = "dog dog dog dog" 应该返回 false。
 * 注意： 你可以假设模型只包含小写字母，并且字符串包含由空格分开的小写字母单词。
 * */

public class Solution290 {
	
	/* 利用HashMap，key+value的组合。
	 * 将每个字母映射到一个单词，比如例1，a对应dog，b对应cat。判断条件是已知a判断word是否为dog；已知存在cat判断
	 * 其key是否已经存在并且不是a。
	 * */
	
    public boolean wordPattern(String pattern, String str) {
    	String[] words = str.split(" ");
    	if (words.length != pattern.length()) {
    		return false;
    	}
    	HashMap<Character, String> map = new HashMap<Character, String>();
    	for (int i = 0; i < pattern.length(); i++) {
    		if (map.containsKey(pattern.charAt(i))) {
    			// map中应当包括a和dog的组合，但是a还可能对应cat
    			if (!map.get(pattern.charAt(i)).equals(words[i])) {
    				return false;
    			}
    		} else {
    			// 对于map中a和dog的组合，选在word为cat对应的仍然是a
    			if (map.containsValue(words[i])) {
    				return false;
    			}
    			map.put(pattern.charAt(i), words[i]);
    		}
    	}
    	return true;
    }
}
