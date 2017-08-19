package math;

import java.util.HashSet;

/* ���⣺
 * дһ���㷨���ж�һ�������Ƿ�happy���� һ��happy������ͨ������Ĺ������б�ģ�
 * ��һ����������ʼ�������λ���ֵ�ƽ��������������Ȼ���ظ��������ֱ�����ֵ���1����ʱ�ͱ��ֲ����ˣ���
 * ��������һֱѭ����������1����Щ�õ�1�����־���happy�����֡�
 * 
 * ������19��һ��happy���� 
   1^2 + 9^2 = 82 
   8^2 + 2^2 = 68 
   6^2 + 8^2 = 100 
   1^2 + 0^2 + 0^2 = 1 
 * */

public class Solution202 {
	
	/* ��������ֵ�ÿ����λ��ƽ���ͣ�������Ϊ1����ƽ������֮ǰ���ֹ��ľͲ�������ͣ��������Ľ���ж��ǲ���һ���������֡�
	 * */
	
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        // ���ڱ����м���ֵĽ��
        HashSet<Integer> set = new HashSet<Integer>(32);
        int tmp;
        int newN;
        // n��Ϊ1������n��ֵ�����ظ����֣��������ѭ��
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            newN = 0;
            //������19����
            while (n > 0) {
                tmp = n % 10;
                n /= 10;
                newN += tmp * tmp;
            }
            n = newN;
        }
        return n == 1;
    }
}
