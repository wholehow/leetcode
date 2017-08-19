package two_pointers;

/* ���⣺
 * ����һ���������飬дһ���������ƶ����е����С�0����ĩβ����������������Ԫ�ص����˳�򲻱䡣 
 * ����˵���������� nums = [0, 1, 0, 3, 12]�����ú���֮��numsӦ�ñ��[1, 3, 12, 0, 0]��
 *  ע�⣺ ���ܸ������飨�ռ临�Ӷ�(O(1)���� 
 *  ʹ�����������ܵ��٣�ʲô���޷����T-T����
 */

public class Solution283 {
	
	/* �۲������ʵ�����֣��ھ����ƶ������з�0�����Ա����������
	 * �ⲻ�����ȶ������㷨�ı���ô�����һ���������ֱ��ʹ�������㷨��߯�����ˡ�
	 * ֱ����ֱ�Ӳ�����������ռ临�Ӷȵ�Ҫ��
	 * */
	
    /*public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return; 
        }       
        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
            	nums[insertPos++] = num;
            }
        }        
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }*/
	
	/* ˫ָ�뷨��
	 * left��right��ʼ��Ϊ0��right�����жϽ���������left�����ڽ����Ĺ����м�¼������λ�õı仯��
	 * */
	
    public void moveZeroes(int[] nums) {
        // Write your code here
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
