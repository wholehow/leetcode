package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 大意：
 * 假设Andy和Doris想要选择一家餐厅吃饭，他们都有一个由字符串表示的最喜欢的餐馆。
 * 你需要帮助他们找到他们的共同兴趣与最小的列表索引总和。如果在答案之间有选择关系，输出所有这些都没有订单要求。你可以假设总有一个答案。
 * 例如：
 * 输入：["Shogun", "Tapioca Express", "Burger King", "KFC"] ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出：["Shogun"]，他们都喜欢的唯一的餐厅是“Shogun”。
 * 输入：["Shogun", "Tapioca Express", "Burger King", "KFC"] ["KFC", "Shogun", "Burger King"]
 * 输出：["Shogun"]，他们喜欢的餐厅和索引总和最小的是“Shogun”，索引总和为1（0 + 1）。
 * */

public class Solution599 {
	
	/* 使用两个Map存储元素，然后求取最小值（公有key且索引和最小）。
	 * */
	
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        int min = Integer.MAX_VALUE;
        ArrayList<String> minRst = new ArrayList<String>();
        
        for (int i = 0; i < list1.length; i++) {
        	map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
        	map2.put(list2[i], i);
        }
        
        for (int i = 0; i < list1.length; i++) {
        	if (map2.containsKey(list1[i])) {
        		int sum = map1.get(list1[i]) + map2.get(list1[i]);
        		if (sum <= min) {
        			min = sum;
        			minRst.add(list1[i]);
        		}
        	}
        }
        String[] rstStrs = new String[minRst.size()];
        for (int i = 0; i < rstStrs.length; i++) {
        	rstStrs[i] = minRst.get(i);
        }
        return rstStrs;
    }
}
