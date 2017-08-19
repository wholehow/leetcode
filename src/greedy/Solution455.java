package greedy;

import java.util.Arrays;

/* 给定两个数组，分别表示每个小孩期望的饼干尺寸，和每个饼干实际的尺寸。
 * 将饼干分配给这些小孩，但分配的饼干尺寸必须不小于小孩期望的饼干尺寸。求出这些饼干最多可以满足几个小孩。
 * 例如：
 * 输入：[1,2,3], [1,1]
 * 输出：1
 * 输入：[1,2], [1,2,3]
 * 输出：2
 * */

public class Solution455 {
	
	/* 解法很简单。先将两个数组进行排序。因为对于s来说，如果s[i]满足g[j]，那么s[i]一定满足g[j - 1]。
	 * 题目要求的是最多可以满足多少个小孩，所以宁可s[i]>=g[j]而不要s[i]<g[j]。
	 * 遍历g和s，如果s符合则两个数组都向前进一，表示有一个饼干满足了一个小孩；如果s尺寸不符合，则s数组向前进一，尝试下一个饼干。
	 * */
	
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
        	if (s[j] >= g[i]) {
        		i++;
        		j++;
        		res++;
        	} else {
        		j++;
        	}
        }
        return res;
    }
}
