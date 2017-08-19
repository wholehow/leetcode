package two_pointers;

/* ���⣺
 * ����һ���������飬�Ƴ��ظ������֣���ÿ��Ԫ��ֻ����һ�Σ��������µĳ��ȡ�
 * ��Ҫ�������Ŀռ����һ�����飬������ڹ̶����ڴ���ȥ����
 * ������ �������������Ϊ nums = [1,1,2]��
 * ��ĺ���Ӧ�÷��س��� = 2������ǰ����������Ϊ������1��2�����³���֮���λ������ν��������ʲô���ݡ�
 */

public class Solution26 {
	
	/* ˫ָ�뷨���ˡ�
	 * ��ʼ j = 0, i = 1��
	 * ��������i = j + 1�����nums[i] == nums[j]����ô���ǵ���i��ֱ��nums[i] != nums[j]��
	 * ��ʱ������������nums[j + 1] = nums[i]��ͬʱ����i��j���ظ���������ֱ������������
	 * �������� nums = [1, 1, 2, 3]
	 * ����i = 1��j = 0����ʱ��nums[i] =numsA[j]�����ǵ���i������2��������1��
	 * ��ʱ����nums[j + 1] = nums[i]��Ҳ����nums[1] = nums[2]������i��jΪ3��1����ʱ��nums[3] != nums[1]��
	 * ����nums[j + 1] = nums[i]��Ҳ����nums[2] = nums[3]���ٴε���������������
	 * ��ʱ���µ����鳤�Ⱦ�Ϊ2 + 1��Ҳ����3��
	 * */
	
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
    
    /*һ�ָ�������д��*/
    /* position��Ϊ�����nums���ߵ���λ��
     * lastNumberΪ�ϸ�nums[i]��ֵ
     * */
    /*public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
        int position = 1;
        int lastNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lastNumber) {
                nums[position] = nums[i];
                position++;
                lastNumber = nums[i];
            }
        }
        return position;
    }*/
}
