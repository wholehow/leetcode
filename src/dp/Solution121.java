package dp;

/* 大意：
 * 有一个由每天的股票价格组成的数组。 如果你只能进行一次交易（比如购买或者销售一个股票），设计一个算法来获取最大利润。 
 * 
 * 例如：
 * 输入：[7, 1, 5, 3, 6, 4] 
 * 输出：5。最大的利润为：6-1 = 5（不是7-1 = 6，因为销售价格需要比购买价格大）。
 * 
 * 输入：[7, 6, 4, 3, 1]
 * 输出：0。 这个例子中，无法进行交易，所以最大收益为0。
 * */

public class Solution121 {
	
	/* 我们只需要遍历一次数组，通过一个变量记录当前最低价格，同时算出此次交易利润，并与当前最大值比较就可以了。
	 * */
	
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        if (maxProfit < 0) {
            return 0;
        }
        return maxProfit;
    }
}
