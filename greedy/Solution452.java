package greedy;

import java.util.Arrays;

/* 有多个球形气球在二维空间中传播。 对于每个气球，提供的输入是水平直径的开始和结束坐标。 
 * 由于它是水平的，所以y坐标无关紧要，因此直径的开始和结束的x坐标就足够了。 开始总是小于结束。 
 * 最多有10^4个气球。
 * 箭头可以沿着x轴的不同点从垂直方向射出。 如果xstart≤x≤xend，则xstart和xend的气球会以x的箭头射击。
 * 可以射击的箭头数量没有限制。 一次箭一度持续无限地前进。 问题是找到必须射击的最小数量的箭头来爆破所有气球。
 * */

public class Solution452 {
	
	/* 就是找坐标的中间。因为如果两个气球如果重叠，射中一个另一个自然也爆破了。
	 * 我们可以按其结束位置对气球数组进行排序。然后我们确保从一开始就照顾每个气球，我们可以射击尽可能多的气球。
	 * */
	
	public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);	// 排序
        int arrowPos = points[0][1];	// 以第二排作为基准开始
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {	// 下一个气球可以覆盖
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
