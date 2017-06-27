package array;

import java.awt.List;
import java.util.TreeMap;

/* ���⣺
 * ����m�����飬ÿ���������������ͬ����֮����Сֵ�����ֵ֮���ֵ����ֵ�����ֵ��
 * 
 * ���磺
 * ���룺[[1,2,3], [4,5], [1,2,3]]
 * �����4����[1,2,3]��1��[4,5]��5��ֵ���Ϊ4��
 * */

public class Solution624 {
	
	/* �������뵽�ķ�����һ�˱�����maxֻ������������ĩβ��minֻ�����������Ŀ�ͷ����ans��¼��ֵ��
	 * */
    /*public int maxDistance(List<List<Integer>> arrays) {
    	if (arrays == null || arrays.size() == 0) {
    		return 0;
    	}
    	int ans = 0;
    	int min = arrays.get(0).get(0);
    	int max = arrays.get(0).get(arrays.get(0).size() - 1);
    	for (int i = 1; i < arrays.size(); i++) {
    		ans = Math.max(ans, Math.abs(arrays.get(i).get(0) - max));
    		ans = Math.max(ans, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
    		max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
    		min = Math.min(min, arrays.get(i).get(0));
    	}
    	return ans;
    }*/
	
	/* �ڶ���˼·��
	 * ʹ��JAVA�ĺ����ʵ��TreeMap��
	 * ��������maxMap, minMap�ֱ�洢arrays����������ֵ����Сֵ��
	 * ����arrays���ǵ�ǰ����Ϊarray������Сֵmin = array[0], ���ֵmax = array[array.length - 1]
	 * �ֱ�max��min��maxMap��minMap���Ƴ�
	 * ����maxMap.lastKey() - min��max - minMap.firstKey()���´�
	 * Ȼ��max��min��ӻ�maxMap��minMap
	 * */
	
    public int maxDistance(List<List<Integer>> arrays) {
    	if (arrays == null || arrays.size() == 0) {
    		return 0;
    	}
        TreeMap<Integer, Integer> maxMap = new TreeMap<>();	//��¼ÿ��array���ֵ
        TreeMap<Integer, Integer> minMap = new TreeMap<>();	//��¼ÿ��array��Сֵ
        for (List<Integer> array : arrays) {
            int min = array.get(0), max = array.get(array.size() - 1);
            maxMap.put(max, maxMap.getOrDefault(max, 0) + 1);
            minMap.put(min, minMap.getOrDefault(min, 0) + 1);
        }
        int ans = 0;
        for (List<Integer> array : arrays) {
            int min = array.get(0), max = array.get(array.size() - 1);
            if (maxMap.put(max, maxMap.get(max) - 1) == 1) {
                maxMap.remove(max);
            }
            if (minMap.put(min, minMap.get(min) - 1) == 1) {
                minMap.remove(min);
            }
            ans = Math.max(ans, maxMap.lastKey() - min);
            ans = Math.max(ans, max - minMap.firstKey());
            maxMap.put(max, maxMap.getOrDefault(max, 0) + 1);
            minMap.put(min, minMap.getOrDefault(min, 0) + 1);
        }
        return ans;
    }
}
