package dp;

/* 大意：
 * 给定非空字符串s和包含非空字列表的字典wordDict，确定s是否可以分割成一个或多个字典单词的空格分隔的序列。你可以假设字典不包含重复的单词。
 * 例如：
 * s = "leetcode",dict = ["leet", "code"].
 * 返回true，因为“leetcode”可以被分割为“leet code”。
 * 更新 (2017/1/4)
 * wordDict参数已更改为字符串列表（而不是一组字符串）。请重新加载代码定义以获取最新的更改。
 * */

public class Solution139 {
	
	/* wordDict中的单词一定是s中的子串。还有一点我们创建DP数组如果没有还原输入的意图，我们希望得到的只有最后一个位置的值而已。
	 * 举个例子leetcode作为s，如果t的位置我们知道code中e的位置值为true，说明对于leet我们肯定是已经找到过true。
	 * 为了实现上述过程需要判断wordDict中单词的最小/最大长度。
	 * */
	
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;
        // 统计wordDict中单词的最小/最大长度，因为后面要用到求子串操作
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int len = minLen; len <= maxLen; len++) {
                if (i + len > n) break;
                String curr = s.substring(i, i + len);
                // 注意判断条件：子串存在并且当前位置已经是true，也就是说当前位置必须满足是一个单词
                if (wordDict.contains(curr) && dp[i]) {
                    dp[i + len] = true;
                }
                if (dp[n]) return true;
            }
        }
        return dp[n];
    }
}
