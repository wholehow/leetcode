package dp;

/* ���⣺
 * ��һ����ÿ��Ĺ�Ʊ�۸���ɵ����顣 �����ֻ�ܽ���һ�ν��ף����繺���������һ����Ʊ�������һ���㷨����ȡ������� 
 * 
 * ���磺
 * ���룺[7, 1, 5, 3, 6, 4] 
 * �����5����������Ϊ��6-1 = 5������7-1 = 6����Ϊ���ۼ۸���Ҫ�ȹ���۸�󣩡�
 * 
 * ���룺[7, 6, 4, 3, 1]
 * �����0�� ��������У��޷����н��ף������������Ϊ0��
 * */

public class Solution121 {
	
	/* ����ֻ��Ҫ����һ�����飬ͨ��һ��������¼��ǰ��ͼ۸�ͬʱ����˴ν������󣬲��뵱ǰ���ֵ�ȽϾͿ����ˡ�
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
