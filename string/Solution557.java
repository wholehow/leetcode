package string;

/* 大意：
 * 给定字符串，将每个单词逐字符逆置，返回新字符串。
 * 注意：字符串中单词之间有且只有1个空格分开。
 * 
 * 例如：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"：
 * */

public class Solution557 {
	
	/* 用空格分割字符串，对每个子串，逆序，添加到结果数组。
	 * */
	
    public String reverseWords(String s) {  
        String[] strs = s.split(" ");  
        String resStr = "";  
        for (int i = 0; i < strs.length - 1; i++) {  //单独处理最后一个单词
            resStr += reverse(strs[i]) + " ";  
        }
        resStr += reverse(strs[strs.length - 1]);	
        return resStr;  
    }  
    public String reverse(String str) {  
        String result = "";  
        for (int i= str.length() - 1; i >= 0; i--)   
            result += str.charAt(i);  
        return result;  
    }  
}
