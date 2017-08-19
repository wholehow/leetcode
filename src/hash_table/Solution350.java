package hash_table;

import java.util.ArrayList;
import java.util.HashMap;

/* ���⣺
 * �����������飬��д�����������ǵĽ�����
 * ע�⣺
 * 1.����е�ÿ��Ԫ�صĳ��ִ���Ӧ����������������ͬʱ���ֵĴ���һ���ࡣ
 * 2.������Բ�������˳��
 * ���磺���� nums1 = [1, 2, 2, 1]��nums2 = [2, 2]������[2, 2]��
 * */

public class Solution350 {
	
	/* ��349�ⷨ����һ�£�ֻ����Ҫ������intersect���ظ���������
	 * ͬ������HashMap��¼�����������Ҫ��¼nums1[]�г��ִ����������ڽ����resultMap�м�¼ͬʱ��nums2[]���ֵĴ�����
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
