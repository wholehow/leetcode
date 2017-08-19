package dp;

/* 大意：
 * 考虑字符串s是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以s将如下所示：“... zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd ....”。
 * 现在我们有另一个字符串p。你的工作是找出p中存在多少唯一的非空子串。特别地，你的输入是字符串p，你需要在字符串s中输出p的不同非空子串的数目。
 * 例如：
 * 输入："a"
 * 输出：1，只有字符串“a”的子串“a”在字符串s中。
 * 输入："cac"
 * 输出：2，字符串s中的字符串“cac”有两个子字符串“a”，“c”。
 * 输入："zab"
 * 输出：6，字符串s中的字符串“zab”有六个子字符串“z”，“a”，“b”，“za”，“ab”，“zab”。
 * */

public class Solution467 {
	
	/* 只要p非空长度不为0，那么至少有一个。因此len计数初值为1。
	 * 这里p都是小写字母，设置字母表alphabets=new int[26]，寓意以每个字母结尾的时候究竟可以用多少个非空子串。
	 * 如何判断za这种？(z+1)%26一定会得到a。
	 * */
	
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
        	return 0;
        }
        int len = 1;
        int[] alphabets = new int[26];
        // 初始化alphabets第一个位置
        alphabets[p.charAt(0) - 'a'] = 1;
        // 因为s循环，只要当前位置满足条件那么其之前所有位置都满足条件，即len不断增加；而如果当前位置不满足条件，说明需要重新计数
        for (int i = 1; i < p.length(); i++) {
        	int curr = p.charAt(i) - 'a';
        	int prev = p.charAt(i - 1) - 'a';
        	if ((prev + 1) % 26 == curr) {
        		len++;
        	} else len = 1;	
        	// 以当前位置结尾子串的个数
        	alphabets[curr] = Math.max(alphabets[curr], len);
        }
        int res = 0;
        for (int a : alphabets)
        	res += a;
        return res;
    }
}
