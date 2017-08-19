package hash_table;

import java.util.HashMap;
import java.util.Map;

/* ���⣺
 * ����ƽ���ϵ�n���㶼�ǳɶԲ�ͬ�ģ��������ڡ��ǵ㣨i��j��k����Ԫ�飬ʹ��i��j֮��ľ������i��k֮��ľ��루Ԫ���˳�������
 * �ҵ������ڵ�����������Լ���n���Ϊ500���������ȫ����[-10000��10000]��Χ�ڡ�
 * ���磺
 * ���룺[[0,0],[1,0],[2,0]]
 * �����2��������������[[1,0]��[0,0]��[2,0]]��[[1,0]��[2,0]��[0,0]]
 * */

public class Solution447 {
	
	/* �����Ŀ�е���֡��о������˵���ͼ���Ѿ��ѽⷨ��ʱ�临�Ӷ���������O(N^2)�������벻������ķ�����
	 * ��Ȼ�Ƕ�ά���飬���ǻ��õ���һά����������
	 * */
	
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
        	return 0;
        }
        int rst = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // ����͵�ǰ������ֵĴ���
        for (int i = 0; i < points.length; i++) {
        	for (int j = 0; j < points.length; j++) {
        		if (i == j) {
        			continue;
        		}
        		int dis = getDistance(points[i], points[j]);
        		map.put(dis, map.getOrDefault(dis, 0) + 1);
        	}
            for (int value : map.values()) {
            	// ��ǰ������ֵĴ���һ���Ǳ���һ�γ��ֵĴ�����1
            	// 2*C(n,2)
            	rst += value * (value - 1);
            }
            map.clear();
        }
        return rst;
    }
    
    // ��ȡ��������ľ���
	private int getDistance(int[] p, int[] q) {
		int a = p[0] - q[0];
		int b = p[1] - q[1];
		return a * a + b * b;
	}
}
