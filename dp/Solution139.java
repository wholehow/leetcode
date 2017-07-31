package dp;

/* ���⣺
 * �����ǿ��ַ���s�Ͱ����ǿ����б���ֵ�wordDict��ȷ��s�Ƿ���Էָ��һ�������ֵ䵥�ʵĿո�ָ������С�����Լ����ֵ䲻�����ظ��ĵ��ʡ�
 * ���磺
 * s = "leetcode",dict = ["leet", "code"].
 * ����true����Ϊ��leetcode�����Ա��ָ�Ϊ��leet code����
 * ���� (2017/1/4)
 * wordDict�����Ѹ���Ϊ�ַ����б�������һ���ַ������������¼��ش��붨���Ի�ȡ���µĸ��ġ�
 * */

public class Solution139 {
	
	/* wordDict�еĵ���һ����s�е��Ӵ�������һ�����Ǵ���DP�������û�л�ԭ�������ͼ������ϣ���õ���ֻ�����һ��λ�õ�ֵ���ѡ�
	 * �ٸ�����leetcode��Ϊs�����t��λ������֪��code��e��λ��ֵΪtrue��˵������leet���ǿ϶����Ѿ��ҵ���true��
	 * Ϊ��ʵ������������Ҫ�ж�wordDict�е��ʵ���С/��󳤶ȡ�
	 * */
	
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;
        // ͳ��wordDict�е��ʵ���С/��󳤶ȣ���Ϊ����Ҫ�õ����Ӵ�����
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
                // ע���ж��������Ӵ����ڲ��ҵ�ǰλ���Ѿ���true��Ҳ����˵��ǰλ�ñ���������һ������
                if (wordDict.contains(curr) && dp[i]) {
                    dp[i + len] = true;
                }
                if (dp[n]) return true;
            }
        }
        return dp[n];
    }
}
