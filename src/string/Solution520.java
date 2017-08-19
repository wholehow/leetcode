package string;

/* 大意：
 * 判断单词是否为首字母大写、全部大写或者全部小写。
 * */

public class Solution520 {
	
	/* 这道题给了我们一个单词，让我们检测大写格式是否正确。（可以假定确实只含有字母）
	 * 那么我们要做的就是统计出单词中所有大写字母的个数cnt，再来判断是否属于这三种情况，
	 * 如果cnt为0，说明都是小写，正确；
	 * 如果cnt和单词长度相等，说明都是大写，正确；
	 * 如果cnt为1，且首字母为大写，正确，其他情况均返回false
	 * */
	
    public boolean detectCapitalUse(String word) {
        if (word == null || word.equals("")) {
        	return false;
        }
        int cnt = 0;
        for (Character c : word.toCharArray()) {
        	if (c <= 'Z') {
        		cnt++;
        	}
        }
        return cnt == 0 || cnt == word.length() || (cnt == 1 && word.charAt(0) <= 'Z');
    }
}
