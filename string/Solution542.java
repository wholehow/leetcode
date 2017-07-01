package string;

/* 大意：
 * 给定一个字符串和一个整数k，每2k个字符翻转前k个字符。
 * 如果剩余字符不足k个，则全部翻转。
 * 如果剩余字符在k到2k之间，则翻转前k个字符，剩余字符保持原样。
 * */

public class Solution542 {
	
	/* 每2k个字符来遍历原字符串s，然后进行翻转，翻转的结尾位置是取i+k和末尾位置之间的较小值。
	 * 注意reverse方法下标的计算。
	 * */
	
    public String reverseStr(String s, int k) {
        if (s == null || s.equals("")) {
			return "";
		}
        char[] ans = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
        	if (s.length() - i < k) {
        		reverse(ans, i, s.length());
        	} else {
        		reverse(ans, i, i + k);
        	}
        }
        return new String(ans);
    }
	private void reverse(char[] chs, int start, int end) {
		for (int i = start; i < (start + end) / 2; i++) {
			char tmp = chs[i];
			chs[i] = chs[end - 1 - i + start];	//k=2时，chs[i] = chs[end - 1]
			chs[end - 1 - i + start] = tmp;
		}
	}
}
