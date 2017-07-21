package bit_manipulation;

/* 大意：
 * 给定两个只由小写字母组成的字符串s和t。
 * 字符串t由字符串s打乱顺序并且额外在随机位置添加一个字母组成。
 * 寻找t中新增的那个字母。
 * */

public class Solution389 {
	
	/* 与136殊途同归，都是利用异或操作的性质。
	 * 因为s和t只有一个字符不同，换句话说，每个在s中出现的字符都在t中出现过。
	 * */
	
    public char findTheDifference(String s, String t) {
        char ans = 0;
        for (int i = 0; i < s.length(); i++) {
        	ans ^= s.charAt(i);
        }
        for (int j = 0; j < t.length(); j++) {
        	ans ^= t.charAt(j);
        }
        return ans;
    }
}
