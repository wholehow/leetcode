package string;

/* 大意：
 * 给出一个由大小写字母和空格组成的字符串s，返回其最后一个单词的长度。
 * 如果最后一个单词不存在，返回0。
 * 注意：单词是指仅有非空格字符组成的序列。
 * 
 * 例如： 给出 s = "Hello World", 返回 5。
 * */

public class Solution58 {
	
	/* 从后往前遍历字符串，如果末尾如果有空格，先把空格去除干净，
	 * 然后取字母的长度，再次遇到空格打止，因为是从后往前遍历，不需要全部遍历完整个字符串，所以会比从前往后快。
	 * */
	
    public int lengthOfLastWord(String s) {
        if (s == null || s.equals(" ")) {
            return 0;
        }
        int i = s.length() - 1;
        int spaces = 0;	//统计可能存在空格的数目
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
            spaces++;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return s.length() - spaces - (i + 1);
    }
    
    /* 当然最偷懒的方法是用split方法。
     * */
    
    /*public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if(strs == null || strs.length == 0)
            return 0;

        return strs[strs.length - 1].length();
    }*/
}
