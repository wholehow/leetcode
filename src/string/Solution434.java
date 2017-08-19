package string;

/* 大意：
 * 计算字符串中的非空子串的个数。
 * 
 * 例如：
 * 输入："Hello, my name is John"
 * 输出：5
 * */

public class Solution434 {
	
	/* 偷懒的话就直接使用split方法。
	 * 不过这里还是用最传统的扫描法。
	 * */
	
    public int countSegments(String s) {
        if (s == null || s.equals(" ")) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                cnt++;
            }
        }
        return cnt;
    }
}
