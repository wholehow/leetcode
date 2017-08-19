package string;

/* 计算回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子字符串。
 * 具有不同起始索引或结束索引的子字符串将被视为不同的子字符串，即使它们由相同的字符组成。
 * 例如：
 * 输入："abc"
 * 输出：3，三个回文字符串：“a”，“b”，“c”。
 * 输入："aaa"
 * 输出：6，六个回文字符串：“a”，“a”，“a”，“aa”，“aa”，“aaa”。
 * */

public class Solution647 {
	
	/* 使用count作为全局变量记录最后结果。
	 * 具有不同起始索引或结束索引的子字符串将被视为不同的子字符串，因此最好的方式就是对于位置i上的字符，我们每次从该位置向两侧进行判断，
	 * 如checkPalindrome方法。需要检测i两侧奇数和偶数长度的回文数量。
	 * */
	
	private int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        for (int i = 0; i < s.length(); i++) {
        	checkPalindrome(s, i, i);	// 检查奇数长度回文子串的回文
        	checkPalindrome(s, i, i + 1);	// 检查偶数长度回文子串的回文
        }
        return count;
    }
    // 检查限定长度回文子串的回文
    private void checkPalindrome(String s, int left, int right) {
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		count++;
    		left--;
    		right++;
    	}
    }
}
