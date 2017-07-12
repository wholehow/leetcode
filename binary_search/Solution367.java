package binary_search;

/* �����ȫƽ����������16,25���֣���
 * ��ֹʹ��Math.sqrt()������
 * */

public class Solution367 {
	
	/* ��һ��˼·����Ȼ����ʹ��sqrt�����������ǿ��Լ���i*i�Ƿ�Ϊnum��һ�ʱ���ʵ�֡�
	 * */
	
    /*public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
            	return true;
            }
        }
        return false;
    }*/
	
	/* �ڶ���˼·��ʹ�ö��ֲ��ң�Ҫ���ҵ���Ϊmid*mid��
	 * */
	
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = mid * mid;
            if (tmp == num) {
            	return true;
            } else if (tmp < num) {
            	left = mid + 1;
            } else {
            	right = mid - 1;
            }
        }
        return false;
    }
	
	/* ������˼·������ѧ��
	 * 1 = 1
	 * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 + 3 + 5 + 7 + 9
     * 36 = 1 + 3 + 5 + 7 + 9 + 11
     * ...
     * ���е���ȫƽ�����������������������ĺ͡�
	 * */
	
    /*public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }*/
}
