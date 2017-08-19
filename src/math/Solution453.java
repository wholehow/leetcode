package math;

/* �����ƶ�����ʹ����Ԫ����ȡ�
 * ���磺
 * ���룺[1,2,3]
 * �����3������[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]��ÿһ����������Ԫ�ص�ֵ����
 * */

public class Solution453 {
	
	/* ������������һ������Ϊn�����飬˵������ÿ�ο��Զ�n-1������ͬʱ��1����������Ҫ���ٴ������Ĳ������������������е�������ȡ�
	 * ��ô�����룬Ϊ�˿��ٵ���С��࣬��ѡ����Щ���ּ�1�أ����ѿ���ÿ����Ҫ�������������ֵ���������ּ�1�������ܿ��ٵĵ���ƽ��״̬��
	 * ��������������������ʵʵ��ÿ���ҳ����ֵ��Ȼ����������ּ�1�����ж��Ƿ�ƽ�⣬˼·����ȷ������OJ����Ӧ��
	 * ��ȷ�Ľⷨ�൱�������Ҫ��һ���Ƕ��������⣬��ʵ��n-1�����ּ�1��Ч����ͬ�ڸ��Ǹ�δ��ѡ�е����ּ�1��
	 * ��������[1��2��3], ����ȥ���ֵ���������ּ�1����Ϊ[2��3��3]��
	 * ����ȫ���1������Ӱ�����ּ���Բ��죬��Ϊ[1��2��2]����������ʵ����ԭʼ��������ֵ3�Լ�1��
	 * ��ô����Ҳ����ת��Ϊ�����������ֶ���С����Сֵ�������ѶȾʹ�󽵵��ˣ�����ֻҪ���ҵ���Сֵ��Ȼ���ۼ�ÿ��������Сֵ֮��Ĳ�ֵ���ɡ�
	 * */
	
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int num : nums) {
        	min = Math.min(min, num);
        }
        for (int num : nums) {
        	res += num - min;
        }
        return res;
    }
}