package string;

/* 大意：
 * 给定一个字符串和一个整数k，你需要从字符串开头的每2k个字符的反转前k个字符。如果剩下的字符少于k个字符，则反转所有字符。
 * 如果小于2k但大于或等于k个字符，则反转前k个字符并将另一个作为原始字符。
 * 例如：
 * 输入： s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * */

public class Solution541 {
	
	/* reverse方法用来反转每2k个字符的前k的字符。
	 * */
	
    public String reverseStr(String s, int k) {
        if (s == null || s.equals("")) {
			return "";
		}
        char[] ans = s.toCharArray();
	// i每次向前跳进2k距离。
        for (int i = 0; i < s.length(); i += 2 * k) {
        	// 不够k个，直接反转剩下的
        	if (s.length() - i < k) {
        		reverse(ans, i, s.length());
        	} else {
        		reverse(ans, i, i + k);
        	}
        }
        return new String(ans);
    }
	private void reverse(char[] chs, int start, int end) {
		for (int i = start; i < (start + end) / 2; i++) {
			char tmp = chs[i];
			chs[i] = chs[end - 1 - i + start];
			chs[end - 1 - i + start] = tmp;
		}
	}
}
