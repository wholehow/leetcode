package array;

import java.util.Arrays;

/* ���⣺
 * ������������õ�����nums1��nums2����nums2�ϲ���nums1�г�Ϊһ���ź�������顣
 * ����Լ��� nums1 ���㹻�Ŀռ䣨�ߴ���ڵ��� m + n������Ӵ� nums2 ���Ķ����Ԫ�ء�
 * nums1 �� nums2 �е�Ԫ�ظ����ֱ�Ϊ m �� n��
 * */

public class Solution88 {
	
	/* ��ķ�����������һ���µ�����nums��Ȼ��nums1������nums���Ƚ�nums��nums2ÿ��λ�õĴ�С������С�߿�����nums1��
	 * ���ַ������ǿռ任ʱ�䡣�ռ临�Ӷ�O(m + n)��ʱ�临�Ӷ�O(m + n)��
	 * */
    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
        	return;
        }      
        int[] nums = Arrays.copyOfRange(nums1, 0, m);	//�����nums1�������ս��
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
        //���nums2�Ѿ��գ�nums�ǿ�
        while (i < nums.length) {
            nums1[k] = nums[i];
            i++;
            k++;
        }
      //���nums�Ѿ��գ�nums2�ǿ�
        while (j < nums2.length) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
        
        return;
    }*/
	
	/* ��Ϊnums1��nums2�����Ѿ��ź�������飬����nums1�Ĵ�С���㹻m+n�ġ�
	 * ���ǿ��Կ��ǴӺ���ǰ�ţ��ȷ������������Ӵ�С������ǰ�ߡ�
	 * ��Ϊ���㹻��λ�ã��ŵ���һ�����Ḳ��ԭ��nums1�е�����
	 * ���nums2�е����ȷ��꣬��ôʣ�µ�nums1ǰ�����λ�ò��ö���
	 * ���nums1���ȷ��꣬ʣ�»���һЩnums2������ֱ�ӷ���ǰ��ȥ�ˡ�
	 * */
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return;
        }
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        //nums1�ѷ��꣬nums2ʣ�µ�ֱ�ӷŵ���ͷ
        while (j > -1) {
            nums1[k--] = nums2[j--];
        }
        return;
    }
}
