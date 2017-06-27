package array;

import java.awt.List;
import java.util.TreeMap;

/* 大意：
 * 给定m个数组，每个数组递增有序。求不同数组之间最小值、最大值之间差值绝对值的最大值。
 * 
 * 例如：
 * 输入：[[1,2,3], [4,5], [1,2,3]]
 * 输出：4，即[1,2,3]的1和[4,5]的5差值最大为4。
 * */

public class Solution624 {
	
	/* 最容易想到的方法是一趟遍历。max只会出现在数组的末尾，min只会出现在数组的开头，用ans记录差值。
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
	
	/* 第二种思路：
	 * 使用JAVA的红黑数实现TreeMap。
	 * 构造红黑树maxMap, minMap分别存储arrays各数组的最大值和最小值。
	 * 遍历arrays，记当前数组为array，其最小值min = array[0], 最大值max = array[array.length - 1]
	 * 分别将max和min从maxMap，minMap中移除
	 * 利用maxMap.lastKey() - min和max - minMap.firstKey()更新答案
	 * 然后将max和min添加回maxMap与minMap
	 * */
	
    public int maxDistance(List<List<Integer>> arrays) {
    	if (arrays == null || arrays.size() == 0) {
    		return 0;
    	}
        TreeMap<Integer, Integer> maxMap = new TreeMap<>();	//记录每个array最大值
        TreeMap<Integer, Integer> minMap = new TreeMap<>();	//记录每个array最小值
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
