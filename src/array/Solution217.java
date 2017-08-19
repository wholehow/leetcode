package array;

import java.util.Arrays;

/* ���⣺
 * ����һ��int�͵����飬�ж������Ƿ�������ظ�������
 * ������κε���ֵ�ں����г��ֹ��������Σ���Ӧ�÷���true�����ÿ����ֵ���ǵ�һ�ģ���ô�ͷ���false��
 * */

public class Solution217 {
	
	/* ����ú�����飬�������ͬ����ֵһ�����������ڵ�λ�á�
	 * һ�α���������� ��
	 * */
	
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
