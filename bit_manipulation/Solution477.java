package bit_manipulation;

/* ��⺺������֮�͡�
 * ���磺
 * ���룺4, 14, 2
 * �����6���ڶ����Ʊ�ʾ�У�4��0100��14��1110����2��0010��ֻ�� �������������ʾ��λ��أ���
 * ���Դ��ǣ� �������루4,14��+�������루4,2��+�������루14,2��= 2 + 2 + 2 = 6��
 * */

public class Solution477 {
	
	/* ����32λ���������ǿ��Էֿ�����ÿ��ֻ����һλ�����磬ÿ��ֻ����nums��ÿ�����ֵ����λ��
	 * ����nums����i�������λΪ0����j�������λΪ1��ͨ����������һ�����Եõ����λΪ1������
	 * ��ô���������ж���������أ���������i*j0�֡�������ǿ�����Ϊ��ǰλ����������Ĺ��׶Ⱦ���i*j��
	 * */
	
    public int totalHammingDistance(int[] nums) {
        int n = 31;	// 32λ����
        int len = nums.length;
        int[] bitCounts = new int[n];	// ע�������С�Ǹ���int�����Ͷ�����nums�ĳ���
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                bitCounts[j] += (nums[i] >> j) & 1;
            }
        }
        int sum = 0;
        for (int count: bitCounts) {
        	// ��ǰλ����������Ĺ��׶Ⱦ���i*j
            sum += count * (len - count);
        }
        return sum;
    }
}
