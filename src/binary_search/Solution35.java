package binary_search;

/* ���⣺
 * ���ڸ����ź��������nums�Լ�����ֵtarget����nums�в���nums[i] == target��
 * ����ҵ��ͷ���i�����û�ҵ��򷵻���Ӧ��������λ�õ��±ꡣ
 * 
 * ���磺
 * [1,3,5,6], 5 �� 2
 * [1,3,5,6], 2 �� 1
 * [1,3,5,6], 7 �� 4
 * [1,3,5,6], 0 �� 0
 * */

public class Solution35 {
	
	/* �о��Ƕ��ֲ��ҵı��֡�
	 * ���target�����������У�����ֲ���һ������O(longN)ʱ�临�Ӷ����ҵ���
	 * �ؼ�����target���������У������ֲ��ҽ�������start > endʱ������Ӧ����λ�ò���λ�á�
	 * ���￼��ľ��ǽ��������ķ�������ʵ��Ŀ�Ѿ�˵�ķǳ������ˣ�ֱ�ӷ���start���ɡ�
	 * */
	
    public int searchInsert(int[] nums, int target) {
    	//�����ھ͸о�LeetCode��Щ�д�����������˷ǳ����
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }	
}
