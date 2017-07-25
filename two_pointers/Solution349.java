package hash_table;

import java.util.Arrays;
import java.util.HashSet;

/* 大意：
 * 寻找两个数组相交的部分。
 * 例如：给定nums1 = [1, 2, 2, 1]，nums2 = [2, 2]，返回[2]。
 * 注意：
 * 1.结果中的每个元素必须唯一
 * 2.结果可以为任意顺序
 * */

public class Solution349 {
	
	/* 为确保结果唯一，需要先将数组排序。
	 * 因为是要寻找两个数组相交的部分，申请一个新的数组temp暂存nums1和nums相交的部分。其长度为nums1.length（其实
	 * 更合理应该是nums1和nums2中length的较大者）。
	 * 只要nums1[i] == nums2[j]（i和j单独循环），就将结果保存在temp中。
	 * 用index记录当前temp占用元素的位置。
	 * 最后将temp的元素一个个取出来存入新的result。
	 * */
	
    /*public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
            	// 保证结果唯一
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
        // 这里必须使用新的数组来保存结果，不然测试用例中一个非空一个为空的输入一定通不过
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        
        return result;
    }*/
	
	/* 类似141，利用集合的性质。可以使用set也可以使用map。
	 * */
	
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        // 将nums1的全部不重复元素放入set
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        // 寻找nums1中有且在set中出现，但是在resSet中没有出现的元素
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
