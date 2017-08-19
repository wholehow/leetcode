package array;

/*
 	���⣺
	����һ���ǿ��������飬���������е������������������ڣ��ͷ�����������ʱ�临�Ӷȱ���ΪO��n����
	
	��1��
	���룺[3, 2, 1]
	�����1
	���ͣ����������Ϊ1��
	
	��2��
	���룺[1, 2]
	�����2
	���ͣ������ڵ��������������Ҫ�������� 2 �����档
	
	��3��
	���룺[2, 2, 3, 1]
	�����1
	���ͣ�ע����������������ָ���ֵ����֡����� 2 ������Ϊ�ڶ��������
*/

public class Solution414 {
	
	/* ����ֻ�ܱ���һ����Ѱ�ҵ��������������ʹ���������α���
	 * firstMax��secondMax��thirdMax
	 * �����μ�¼��ǰ������λ��i��ʱ�̣��ݴ��ǰ�����������
	 * �����������е�һ����������Ϊ��ʼֵ��
	 * 1.�����ǰ���ֱȵ�һ�����ִ���ôԭ����һ�����ֵ�ֵҪ�ƶ����ڶ�����ԭ���ڶ������ֵ�ֵҪ�ƶ�����������
	 * 2.���������ǵڶ������֣�ͬ��Ҫ��ԭ���ڶ������ֵ�ֵ�ƶ�����������
	 * 3.�����������õ�һ��������Ϊ��ʼֵ�ģ�������滻����ʱ����һ��ԭ���������ڶ����͵��������ֻ��ǳ�ʼֵ��
	 * �����������ʼֵ��ͬ�����֣��ǾͲ�Ҫ���ԭ���ִ��ˣ�ֱ���滻�����ƣ�
	 * ���������һ����������Ǽ�ʹ�е���������Ҳ�����¼������
	 * 4.���Ҫ�ж����������ǲ��ǲ�һ������һ���ŷ��ص��������֣������Ҫ�����������֡�
	 */
	
	public int thirdMax(int[] nums) {
		
		//�ݴ�ǰ��������ͱ�����ʼֵΪnums[0]
        int firstMax = nums[0];
        int secondMax = nums[0];
        int thirdMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > firstMax) {	//1.
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] != firstMax && (nums[i] > secondMax || secondMax == firstMax)) {		//2.
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if ((nums[i] != firstMax && nums[i] != secondMax) 
            		&& (nums[i] > thirdMax || thirdMax == secondMax || thirdMax == firstMax)) {		//3.
                thirdMax = nums[i];
            }
        }
        if (firstMax > secondMax && secondMax > thirdMax) {		//4.
        	return thirdMax;
        } else {
       	 	return firstMax;
        }
	}
}
