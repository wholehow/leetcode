package array;

/* ���⣺
 * ���һ���㷨Ѱ��������档
 * ����������ɶ��ٴν��ף����磬���������������Ȼ���㲻��һ�ν��ж�ν��ף����ٴ�����ǰ�����������Ʊ����
 * */

public class Solution122 {
	
	/* ��Ϊ�����ƽ��״����������ڵ�i�����룬�������i + 1���i�ߣ���ô�Ϳ����ۼӵ��������档
	 * ��������121����Ϊɶ��ΪII�أ�T-T
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
