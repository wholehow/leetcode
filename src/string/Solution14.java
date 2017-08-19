package string;

/* 大意：
 * 写一个函数来寻找一个数组的字符串中最长的相同前缀。
 * */

public class Solution14 {
	
	/* 第一次写了个最长前缀匹配，结果怎么都不通过。哈哈~其实不是一个题目，还是不够仔细啊T-T
	 * 用整个第一个字符串来当做前缀去判断每个字符串是否拥有该前缀，没有就将这个判断的前缀末尾字符去掉再比较，
	 * 直到当前判断的字符串有这个前缀了，才去判断下一个字符串有没有，执行同样的操作。
	 * 当任何时候前缀长度减少到0了，也可以直接返回了。
	 * */
	
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";
        } else if (strs.length == 1) {
        	return strs[0];
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
        	while (strs[i].indexOf(pre) != 0) {
        		pre = pre.substring(0, pre.length() - 1);
        		if (pre.length() == 0) {
					return "";
				}
        	}
        }
        return pre;
    }
}
