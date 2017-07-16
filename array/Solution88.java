package array;

import java.util.Arrays;

/* 大意：
 * 给定两个排序好的数组nums1和nums2，将nums2合并到nums1中成为一个排好序的数组。
 * 你可以假设 nums1 有足够的空间（尺寸大于等于 m + n）来添加从 nums2 来的额外的元素。
 * nums1 和 nums2 中的元素个数分别为 m 和 n。
 * */

public class Solution88 {
	
	/* 最笨的方法就是申请一个新的数组nums，然后将nums1拷贝到nums。比较nums和nums2每个位置的大小，将较小者拷贝到nums1。
	 * 这种方法就是空间换时间。空间复杂度O(m + n)，时间复杂度O(m + n)。
	 * */
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
        	return;
        }      
        int[] nums = Arrays.copyOfRange(nums1, 0, m);	//最后用nums1保存最终结果
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums.length && j < nums2.length) {
            if (nums[i] <= nums2[j]) {
                nums1[k] = nums[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        //如果nums2已经空，nums非空
        while (i < nums.length) {
            nums1[k] = nums[i];
            i++;
            k++;
        }
      //如果nums已经空，nums2非空
        while (j < nums2.length) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
        
        return;
    }
	
	/* 因为nums1和nums2都是已经排好序的数组，而且nums1的大小是足够m+n的。
	 * 我们可以考虑从后往前排，先放最后面的数，从大到小慢慢往前走。
	 * 因为有足够的位置，放的数一定不会覆盖原来nums1中的数。
	 * 如果nums2中的数先放完，那么剩下的nums1前面的数位置不用动；
	 * 如果nums1的先放完，剩下还有一些nums2的数就直接放在前面去了。
	 * */
	
    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return;
        }
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        //nums1已放完，nums2剩下的直接放到开头
        while (j > -1) {
            nums1[k--] = nums2[j--];
        }
        return;
    }*/
}
