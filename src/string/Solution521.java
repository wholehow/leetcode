package string;

/* 大意：
 * 给定两个字符串，计算其“最长非公共子序列”。
 * 最长非公共子序列是指：两字符串中某一个的子序列，该子序列不是另一个字符串的子序列，并且长度最长。
 * 子序列是指从一个序列中删除一些字符，剩余字符顺序保持不变得到的新序列。任何字符串都是其本身的子序列，空串不属于任意字符串的子序列。
 * 返回最长不公共子序列，若不存在，返回-1。
 * 注意：
 * 1.两字符串长度均不超过100
 * 2.输入字符串只包含小写字母a-z
 * 
 * 例如：
 * 输入："aba", "cdc"
 * 输出：3 解释“最长非公共子序列”是"aba"（或"cdc"）因为“aba”是“aba”的子序列却不是“cdc”的子序列。
 * */

public class Solution521 {
	
	/* 我只想说这道题真的真的太坑了！！！
	 * 怎么求最长？如果两个字符串不相等，那其实任意一个字符串本身都是非公共子序列。
	 * 所以结果也出来了，如果字符串不相等，那么“最长非公共子序列”就是较长的那个字符串了。
	 * 如果字符串相等，可想而知不可能找到“最长非公共子序列”。
	 * */
	
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
