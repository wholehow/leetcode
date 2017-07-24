package hash_table;

import java.util.HashSet;
import java.util.Set;

/* 给定一个由小写或大写字母组成的字符串，找到可以用这些字母构建的最长的回文长度。
 * 例如：
 * 输入："abccccdd"
 * 输出：7，可以建造的最长的回文是“dccaccd”，长度为7。 
 * */

public class Solution409 {
	
	/* 利用set的性质，遍历给定字符串，如果set的大小为0，说明原来的字符串一定可以整体构成一个回文，
	 * 否则最长的回文就是字符串的长度减去set的大小。
	 * */
	
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        Set<Character> set = new HashSet<>();
        for (char letter : s.toCharArray()) {
        	// 如果已经存在就两者都删除，因为它们一定可以组成一个回文
        	if (set.contains(letter)) {
        		set.remove(letter);
        	} else {
        		set.add(letter);
        	}
        }
        int size = set.size();
        // 为什么要减1？如果只剩下一个，它本身也一定是一个回文。比如abccb，最长回文是5，而最后set中剩下的就是a。
        return s.length() - (size == 0 ? 0 : size - 1);
    }
}
