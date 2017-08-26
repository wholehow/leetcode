package backtracking;

/* 如果整数1到N的排列，第i个数满足下列规则之一，则称该排列为“美丽排列”
 * 1.第i个位置的数字可以被i整除
 * 2.i可以被第i个位置的数字整除
 * 给定数字N，求有多少个美丽排列
 * 例如：
 * 输入:2
 * 输出：2
 * 第一个美丽序列是[1, 2]
 * 1可以被位置1整除，2可以被位置二整除
 * 第二个美丽序列是[2, 1]
 * 同理
 * */

public class Solution526 {
	
	/* 记忆搜索。
	 * 搜索函数定义为：helper(N, idx, visited)
	 * 其中idx为当前数字的下标visited为当前位置是否被访问过
	 * 初始令idx = 1, nums = [1 .. N]
	 * 遍历nums，记当前数字为n，visited置为true
	 * 若n满足题设的整除条件，则将helper(idx + 1, nums)累加至答案，visited置为false
	 * */
	
    public int countArrangement(int N) {
        return helper(N, 1, new boolean[N + 1]);
    }
    private int helper(final int N, int idx, boolean[] visited) {
    	if (idx > N) return 1;
    	int res = 0;
    	for (int i = 1; i <= N; i++) {
			if (!visited[i] && (i % idx == 0 || idx % i == 0)) {
				visited[i] = true;
				res += helper(N, idx + 1, visited);
				visited[i] = false;
			}
		}
    	return res;
    }
}
