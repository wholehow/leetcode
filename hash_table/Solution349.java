package hash_table;

import java.util.Arrays;
import java.util.HashSet;

/* ���⣺
 * Ѱ�����������ཻ�Ĳ��֡�
 * ���磺����nums1 = [1, 2, 2, 1]��nums2 = [2, 2]������[2]��
 * ע�⣺
 * 1.����е�ÿ��Ԫ�ر���Ψһ
 * 2.�������Ϊ����˳��
 * */

public class Solution349 {
	
	/* Ϊȷ�����Ψһ����Ҫ�Ƚ���������
	 * ��Ϊ��ҪѰ�����������ཻ�Ĳ��֣�����һ���µ�����temp�ݴ�nums1��nums�ཻ�Ĳ��֡��䳤��Ϊnums1.length����ʵ
	 * ������Ӧ����nums1��nums2��length�Ľϴ��ߣ���
	 * ֻҪnums1[i] == nums2[j]��i��j����ѭ�������ͽ����������temp�С�
	 * ��index��¼��ǰtempռ��Ԫ�ص�λ�á�
	 * ���temp��Ԫ��һ����ȡ���������µ�result��
	 * */
	
    /*public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
            	// ��֤���Ψһ
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        // �������ʹ���µ�����������������Ȼ����������һ���ǿ�һ��Ϊ�յ�����һ��ͨ����
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        
        return result;
    }*/
	
	/* ����141�����ü��ϵ����ʡ�����ʹ��setҲ����ʹ��map��
	 * */
	
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        // ��nums1��ȫ�����ظ�Ԫ�ط���set
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        // Ѱ��nums1��������set�г��֣�������resSet��û�г��ֵ�Ԫ��
        HashSet<Integer> resSet = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i]) && !resSet.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }
        
        int size = resSet.size();
        int[] result = new int[size];
        int index = 0;
        for (Integer num : resSet) {
            result[index++] = num;
        }
        
        return result;
    }

}
