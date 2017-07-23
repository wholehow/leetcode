package hash_table;

import java.util.HashMap;
import java.util.Map;

/* ���⣺
 * ���Ƕ���һ����г������һ�����飬�����ֵ����Сֵ֮��Ĳ�ֵǡ��Ϊ1��
 * ���ڣ�����һ���������飬����Ҫ�������п��ܵ�������֮���ҵ�����ĺ�г�����еĳ��ȡ�
 * ���磺
 * ���룺[1,3,2,2,5,2,3,7]
 * �����5����ĺ�г��������[3,2,2,2,3]��
 * */

public class Solution594 {
	
	/* �����÷��������е���ʽ��ֻ��Ҫ��������ʽ�������ͱȽϼ��ˡ�
	 * ��������HashMapͳ��ÿ�����ֳ��ֵĴ�������Ҫ�Ĳ�ֵΪ1����map.containsKey(key+1)��Ҫ��map�С�
	 * ÿ�ν��ֵΪmap.get(key+) + map.get(key)��result�еĽϴ��ߡ�
	 * */
	
    public int findLHS(int[] nums) {
        if (nums == null || nums.length < 0) {
			return -1;
		}
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int rst = 0;
        for (int key : map.keySet()) {
        	if (map.containsKey(key + 1)) {
        		rst = Math.max(rst, map.get(key + 1) + map.get(key));
        	}
        }
        return rst;
    }
}
