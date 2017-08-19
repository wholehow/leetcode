package string;

/* 大意：
 * 写一个函数，输入一个字符串然后翻转里面的元音字母。
 * 例1： 给出 s = "hello"，返回"holle"。
 * 例2： 给出 s = "leetcode"，返回"leotcede"。
 * 注意： 元音不包括字母“y”。
 * */

public class Solution345 {
	
	/* 双指针法。
	 * 在字符串的头和尾都放一个指针进行遍历，两端向中间，当两端都遇到元音字母后，就对换。
	 * 直到两个指针碰头为止。
	 * */
	
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chs = s.toCharArray();
        while (left < right) {
            if (isVowel(chs[left]) && isVowel(chs[right])) {
                swap(chs, left++, right--);
            } else if (isVowel(chs[left])) {
                right--;
            } else {
                left++;
            }
        }
        return new String(chs);
    }
    private boolean isVowel (char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' 
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
