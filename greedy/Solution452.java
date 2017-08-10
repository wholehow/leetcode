package greedy;

import java.util.Arrays;

/* �ж�����������ڶ�ά�ռ��д����� ����ÿ�������ṩ��������ˮƽֱ���Ŀ�ʼ�ͽ������ꡣ 
 * ��������ˮƽ�ģ�����y�����޹ؽ�Ҫ�����ֱ���Ŀ�ʼ�ͽ�����x������㹻�ˡ� ��ʼ����С�ڽ����� 
 * �����10^4������
 * ��ͷ��������x��Ĳ�ͬ��Ӵ�ֱ��������� ���xstart��x��xend����xstart��xend���������x�ļ�ͷ�����
 * ��������ļ�ͷ����û�����ơ� һ�μ�һ�ȳ������޵�ǰ���� �������ҵ������������С�����ļ�ͷ��������������
 * */

public class Solution452 {
	
	/* ������������м䡣��Ϊ���������������ص�������һ����һ����ȻҲ�����ˡ�
	 * ���ǿ��԰������λ�ö����������������Ȼ������ȷ����һ��ʼ���չ�ÿ���������ǿ�����������ܶ������
	 * */
	
	public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);	// ����
        int arrowPos = points[0][1];	// �Եڶ�����Ϊ��׼��ʼ
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {	// ��һ��������Ը���
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
