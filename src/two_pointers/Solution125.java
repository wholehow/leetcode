package two_pointers;

/* 判断一个字符串是否是回文。
 * 
 * 例如：
 * "A man, a plan, a canal: Panama" 是回文。
 * "race a car" 不是回文。
 * 
 * 注意：
 * 你有考虑字符串可能为空吗？这是面试时的一个好问题。
 * 对于这道题的目的，我们假设空字符串也是有效的回文。
 * */

public class Solution125 {
	
	/* 从例子中可以看出，这道题只判断字符串中的大小写字母和数字，空格和其他标点符号都跟没看到一样，也就是在做的时候要忽略。
	 * 另外大小写字母忽略，看做是相同的，这也就意味着在判断是否相同时要将大小写字母转为同一个格式。
	 * 因为只是看一个字符串，算法还是比较简单，就是从两头出发，往中间走，进行两两匹配。
	 * */
	
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
        	while (i < s.length() && !isValid(s.charAt(i))) {
        		i++;
        	}
        	if (i == s.length()) {	//这一句话还是很重要的，考虑特殊情况",..."
        		return true;
        	}
        	while (j >= 0 && !isValid(s.charAt(j))) {
        		j--;
        	}
        	if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
        	i++;
        	j--;
        }
        return j <= i;
    }
    private boolean isValid(char c) {
    	return Character.isLetter(c) || Character.isDigit(c);
	}
}
