package string;

/* 大意：
 * 给出一个非空字符串，检查它是否可以由它的子字符串重复组成。
 * 你可以假设给出的字符串全部由小写字母组成并且它的长度不超过10000。
 * 例如：
 * 输入：“abab” 输出：True 解释：重复两次子字符串 “ab”。
 * 输入：“aba” 输出：False
 * 输入：“abcabcabc” 输出：True 解释：多次重复子字符串 “abc”。（或者重复两次子字符串 “abcabc”。）
 * */

public class Solution459 {
	
    /* 要判断一个字符串是否可以用其某个子串不断重复而得到，最直接的方法就是找出所有的子串，然后判断这个子串是否可以拼接处最终的字符串。
     * 模拟不断拼接字符串的判断。
     * 对于子串长度上的剪枝。
     * */
	public boolean repeatedSubstringPattern(String str) {
	    for (int i = 1; i <= str.length() / 2; i++) {
	        if (str.length() % i != 0) {
	            continue;
	        }
	        String pattern = str.substring(0, i);
	        int start = i;
	        while (start != str.length()) {
	            if (!str.startsWith(pattern, start)) {	//新方法的使用
	                break;
	            }
	            start += pattern.length();
	        }
	        if (start == str.length()) {
	            return true;
	        } 
	    }
	    return false;
	}
	
    /* 其实还有一种更牛的思路。
     * 输入字符串的第一个字符串是重复子字符串的第一个字符
     * 输入字符串的最后一个字符串是重复子字符串的最后一个字符
     * 令S1 = S + S（其中输入字符串中的S）
     * 删除S1的第一个和最后一个字符，生成字符串S2。
     * 如果S存在于S2中，则返回true否则为false。
     * */
}	
