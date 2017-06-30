package string;

/* 大意：
 * 实现 strStr()。
 * 返回 haystack 中第一次出现 needle 的位置，如果 needle 不是 haystack 的一部分则返回 -1。
 * */

public class Solution28 {
	
	/* 最简单的做法就是遍历 haystack ，发现和 needle 第一个字符相同的元素，就开始逐个比较，
	 * 如果全部比完发现一样，那么返回之前那个开始位置就可以了，
	 * 如果中途有不一样的，那么就要从之前的位置的下一个位置开始继续遍历寻找。
	 * */
	
    /*public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
        	return 0;
        }
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        int i = 0;
        int j = 0;
        for (; i < haystackArr.length;i++) {
            if (haystackArr[i] == needleArr[j]) {
                for (int k = i; k < haystackArr.length && j < needleArr.length; k++, j++) {
                    if (haystackArr[k] != needleArr[j]) break;
                }
                if (j == needleArr.length) return i;
                else j = 0;
            }
        }
        return -1;
    }*/
	
	/* 我们可以对上面的代码循环部分进行变形，用dis记录两个字符串的长度差。
	 * 核心思想是使用subString方法。
	 * */
	
	 public int strStr(String haystack, String needle) {
		 int len1 = haystack.length();
		 int len2 = needle.length();
		 if (len1 < len2) {
			return -1;
		 } else if (len2 == 0) {
			return 0;
		 }
		 int dis = len1 - len2;
		 for (int i = 0; i < dis; i++) {
			 if (haystack.substring(i, i + dis).equals(needle)) {
				 	return i;		
			}
		 }
		 return -1;
	 }
}
