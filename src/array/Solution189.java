package array;

/* ���⣺
 * ��תһ����n��Ԫ�ص����飬����k����
 * ���磬n = 7��k = 3������ [1,2,3,4,5,6,7] �ͱ���תΪ [5,6,7,1,2,3,4]��
 * */

public class Solution189 {
	
	/* ��л����ѧ�����뵽��ȡ���ķ�����(A-1)-1 = A��
	 * ˼·���Ȱ�ǰn-k�����ַ�תһ�£��ٰѺ�k�����ַ�תһ�£�����ٰ��������鷭תһ�¡�
	 * */
	
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;	//��Ϊ������kȷʵ�п��ܻ�������鳤�ȣ������������ʹ��ȡ����������ҵ�����������λ�á�
        reverse(nums, 0, nums.length - k - 1);	//����ʹ��reverse(nums, 0, k);
        reverse(nums, nums.length - k, nums.length - 1);	//����ʹ��reverse(nums, k + 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
        /* ����Ҳ����ʹ������һ��˼·��
         * �о�����������Ⱑ������
         * */
        /*reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);*/
    }
    private void reverse(int[] nums, int i, int j){
        int tmp = 0;       
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
