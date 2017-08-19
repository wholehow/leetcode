package hash_table;

import java.util.ArrayList;
import java.util.HashMap;

/* 大意：
 * 给定两个数组，编写函数计算它们的交集。
 * 注意：
 * 1.结果中的每个元素的出现次数应与其在两个数组中同时出现的次数一样多。
 * 2.结果可以采用任意顺序。
 * 例如：输入 nums1 = [1, 2, 2, 1]，nums2 = [2, 2]，返回[2, 2]。
 * */

public class Solution350 {
	
	/* 与349解法基本一致，只是需要考虑在intersect中重复的数量。
	 * 同样利用HashMap记录，不过这次需要记录nums1[]中出现次数，并且在结果的resultMap中记录同时在nums2[]出现的次数。
	 * */
	
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                map.put(nums2[j], map.get(nums2[j]) - 1);
                if (!resultMap.containsKey(nums2[j])) {
                    resultMap.put(nums2[j], 1);
                } else {
                    resultMap.put(nums2[j], resultMap.get(nums2[j]) + 1);
                }
            }
        }

        int sum = 0;
        for (Integer e : resultMap.keySet()) {
            int count = resultMap.get(e);
            sum += count;
            for (int i = 0; i < count; i++) {
                list.add(e);
            }
        }
        int[] result = new int[sum];
        for (int i = 0; i < sum; i++) {
            result[i] = (int) list.get(i);
        }
        return result;
    }
}
