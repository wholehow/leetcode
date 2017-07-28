package array;

/* ���ҷ�ֵԪ�ء�
 * ��ֵԪ����ָ��ǰֵ�������ھӶ���
 * ����һ��Ԫ�ض����ظ������飬�������ֵԪ�ء���num[i] �� num[i+1]��
 * ������ܰ��������ֵ������������£���������һ�����������ԡ�
 * ����Լ���num [-1] = num [n] =-��
 * ���磺
 * ���룺[1, 2, 3, 1]
 * �����3
 * */

public class Solution162 {
	
	/* ��Ŀ˵��ֻҪ��������һ����ֵԪ�ص���������ô���ǿ���ֱ�ӷ����ҵ��ĵ�һ����ֵԪ�ء�
	 * ��ʵ�Ҿ��������Ŀͦûˮƽ�ģ���ĶԲ�����medium���Ѷȡ�
	 * ��Ϊ��num [-1] = num [n] =-����������Ĵ��ڣ������һ�����ֲ��ҵ���Ŀ��
	 * ��Ϊ�����ҵ���ֵ��ʲôλ�ã������ǵ�һ�����������һ������Ϊ������������Ĵ��ڣ����ؽ��һ��������
	 * */
	
    public int findPeakElement(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
            	low = mid+1;
            } else {
            	high = mid;
            }
        }
        return low;
    }
}