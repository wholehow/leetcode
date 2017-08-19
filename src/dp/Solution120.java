package dp;

import java.util.List;

/* ���⣺
 * ����һ�������Σ��Ӷ������ײ��ҵ���С·���͡�ÿ�����裬�����ƶ�����������ϵ��������֡�
 * ���磺
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
	��С·����Ϊ11��2 + 3 + 5 + 1 = 11
 * */

public class Solution120 {
	
	/* ����ṹͦ����������Ԫ�ظ�����
	 * �������ϼ��㣬����DP������⡣
	 * */
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	// ��ʼpreRowΪ���һ��
        List<Integer> preRow = triangle.get(triangle.size() - 1); 
        // ��-2��ʼ����ΪDPʱ��Ҫ�õ�size-1��
        for (int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> curRow = triangle.get(i); 
            int preEle = preRow.get(0);
            for(int j = 0; j < curRow.size(); j++){
            	// ÿ�ζ����ҵ���ǰ������С�����ֱ�����һ��
                 curRow.set(j, curRow.get(j) + Math.min(preEle, preEle = preRow.get(j + 1)));
            }
            preRow = curRow;
        }
        // ��һ�е�һ����Ҳ��Ψһһ�����������
        return triangle.get(0).get(0);
    }
}
