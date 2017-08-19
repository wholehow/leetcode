package hash_table;

import java.util.List;
import java.util.ArrayList;

/* 大意：
 * 给定一个字符串s与一个非空字符串p，寻找s中所有p的字谜变换的起始下标。
 * 字符串只包含小写英文字母并且s和p的长度均不超过20100。
 * 输出顺序无所谓。
 * 例如：
 * 输入：s: "cbaebabacd" p: "abc"
 * 输出：[0, 6]，起始index = 0的子串是“cba”，它是“abc”的字谜变换。起始index = 6的子串是“bac”，它是“abc”的字谜变换。
 * 输入：s: "abab" p: "ab"
 * 输出：[0, 1, 2]，起始index = 0的子串是“ab”，它是“ab”的字谜变换。起始index = 1的子串是“ba”，它是“ab”的字谜变换。
 * 起始index = 2的子串是“ab”，这是“ab”的字谜变换。
 * */

public class Solution438 {
	
	/* 感觉这个题目挺难的，一直想不到先取和后补的方法。
	 * 字符统计，单词的字谜变换（anagram）是指与其字母个数相同只是顺序不同的单词。
	 * */
	
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
        	return list;
        }
        // 用数组模拟HashMap，可以简化操作
        int[] hash = new int[128];
        for (char letetr : p.toCharArray()) {
        	hash[letetr]++;
        }
        // 初始cnt为p的length，，每匹配一个，cnt自减1。
        int start = 0, end = 0, cnt = p.length();
        while (end < s.length()) {
        	// 找到了，就把表示要判断的字符串长度减一
        	if (hash[s.charAt(end)] >= 1) {
        		cnt--;
        	}
        	// 不管有没有找到，都要把数组减少，右标志位右移，这是为了之后进行判断，因为我们要找的的字符串始终处于左标志位和右标志位的中间
        	hash[s.charAt(end)]--;
        	end++;
        	// cnt=0时说明s中以当前字符开始的cnt个位置是满足条件的
        	if (cnt == 0) {
        		list.add(start);
        	}
        	// 类似于滑动窗口，更新过期下标
        	if (end - start == p.length()) {
        		// 找到过则要把count数量补回1
        		if (hash[s.charAt(start)] >= 0) {
        			cnt++;
        		}
        		// 不论有没有找到过，都要把数组中的对应的字母数量补回1。
        		hash[s.charAt(start)]++;
        		start++;
        	}
        }
        return list;
    }
}
