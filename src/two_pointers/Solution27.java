package two_pointers;

/* ���⣺
 * ����һ�������һ�������Ƴ����������е��ڸ�����ֵ�������³��ȡ�
 * ��Ҫʹ�ö���Ŀռ���������һ�����飬������ں㶨���ڴ�������
 * Ԫ�ص�˳����Ըı䡣�³����������������ν��ʲô���ӡ�
 * */

public class Solution27 {
	
	/* ������Ҫ�����ڲ����������飬������ԭ�е��������������в�����
	 * ����Ŀ����˼���ǽ����в������Ǹ�ֵ�����ŵ�����ǰ�棬Ȼ�󷵻���Щ����������Ҳ���������һ�����ȣ�
	 * ������Ⱥ��������ʲô���ӵĶ�û�й�ϵ��
	 * */
	
    /*public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pos = 0;
        for (int curNum : nums) {
            if (curNum != val) {
                nums[pos++] = curNum;
            }
        }
        return pos;
    }*/
	
	/* ����ֻ�Ƿ��س��ȶ�������������������ʽ��������ǿ��Կ��ǽ������������ƶ���ǰ������ظ���λ���Ͻ��и��ǣ�
	 * ����ֻ��Ҫ����ָ�����ɸ㶨��
	 * ע�����ķ��ؽ�����Ǵ���Ľ������ĳ���=�±�+1��
	 * */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int pointer = nums.length - 1;
        while (i <= pointer) {
            if (nums[i] == val) {
                nums[i] = nums[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }
}
