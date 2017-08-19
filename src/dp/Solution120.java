package dp;

import java.util.List;

/* 大意：
 * 给定一个三角形，从顶部到底部找到最小路径和。每个步骤，可以移动到下面的行上的相邻数字。
 * 例如：
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
	最小路径和为11，2 + 3 + 5 + 1 = 11
 * */

public class Solution120 {
	
	/* 矩阵结构挺合理，行数即元素个数。
	 * 从下向上计算，利用DP方法求解。
	 * */
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	// 初始preRow为最后一行
        List<Integer> preRow = triangle.get(triangle.size() - 1); 
        // 从-2开始是因为DP时需要用到size-1行
        for (int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> curRow = triangle.get(i); 
            int preEle = preRow.get(0);
            for(int j = 0; j < curRow.size(); j++){
            	// 每次都是找到当前行中最小数相加直至最后一行
                 curRow.set(j, curRow.get(j) + Math.min(preEle, preEle = preRow.get(j + 1)));
            }
            preRow = curRow;
        }
        // 第一行第一个，也是唯一一个就是最后结果
        return triangle.get(0).get(0);
    }
}
