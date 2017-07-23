package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* ���⣺
 * ����Andy��Doris��Ҫѡ��һ�Ҳ����Է������Ƕ���һ�����ַ�����ʾ����ϲ���Ĳ͹ݡ�
 * ����Ҫ���������ҵ����ǵĹ�ͬ��Ȥ����С���б������ܺ͡�����ڴ�֮����ѡ���ϵ�����������Щ��û�ж���Ҫ������Լ�������һ���𰸡�
 * ���磺
 * ���룺["Shogun", "Tapioca Express", "Burger King", "KFC"] ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * �����["Shogun"]�����Ƕ�ϲ����Ψһ�Ĳ����ǡ�Shogun����
 * ���룺["Shogun", "Tapioca Express", "Burger King", "KFC"] ["KFC", "Shogun", "Burger King"]
 * �����["Shogun"]������ϲ���Ĳ����������ܺ���С���ǡ�Shogun���������ܺ�Ϊ1��0 + 1����
 * */

public class Solution599 {
	
	/* ʹ������Map�洢Ԫ�أ�Ȼ����ȡ��Сֵ������key����������С����
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
