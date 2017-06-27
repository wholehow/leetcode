package array;

/* 大意：
 * 设计一个算法寻找最大收益。
 * 你可以随便完成多少次交易（比如，多次买入卖出）。然而你不能一次进行多次交易（在再次买入前你必须卖出股票）。
 * */

public class Solution122 {
	
	/* 因为不限制交易次数，我们在第i天买入，如果发现i + 1天比i高，那么就可以累加到利润里面。
	 * 这明明比121还简单为啥作为II呢？T-T
	 * */
	
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }
}
