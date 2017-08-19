package hash_table;

import java.util.HashMap;
import java.util.Map;

/* 大意：
 * 给定平面上的n个点都是成对不同的，“回旋镖”是点（i，j，k）的元组，使得i和j之间的距离等于i和k之间的距离（元组的顺序事项）。
 * 找到回旋镖的数量。你可以假设n最多为500，点的坐标全部在[-10000，10000]范围内。
 * 例如：
 * 输入：[[0,0],[1,0],[2,0]]
 * 输出：2，两个回旋镖是[[1,0]，[0,0]，[2,0]]和[[1,0]，[2,0]，[0,0]]
 * */

public class Solution447 {
	
	/* 这道题目有点奇怪。感觉出题人的意图就已经把解法的时间复杂度限制在了O(N^2)，是在想不到更快的方法。
	 * 虽然是二维数组，但是还得当作一维数组来处理。
	 * */
	
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
        	return 0;
        }
        int rst = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 距离和当前距离出现的次数
        for (int i = 0; i < points.length; i++) {
        	for (int j = 0; j < points.length; j++) {
        		if (i == j) {
        			continue;
        		}
        		int dis = getDistance(points[i], points[j]);
        		map.put(dis, map.getOrDefault(dis, 0) + 1);
        	}
            for (int value : map.values()) {
            	// 当前距离出现的次数一定是比上一次出现的次数多1
            	// 2*C(n,2)
            	rst += value * (value - 1);
            }
            map.clear();
        }
        return rst;
    }
    
    // 获取两个坐标的距离
	private int getDistance(int[] p, int[] q) {
		int a = p[0] - q[0];
		int b = p[1] - q[1];
		return a * a + b * b;
	}
}
