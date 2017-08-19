package math;

/* ���⣺
 * ����m * n����M����ʼΪ0��Ȼ��ִ��һЩ���²�����
 * ����ops��ʾһ����²�����ÿһ������(a, b)����ʾ������0 <= i < a ���� 0 <= j < b������ֵ+1��
 * �������ɲ��������������ֵ��
 * ���磺
 * ����m = 3, n = 3��operations = [[2,2],[3,3]]
 * �����4 ����
 * ��ʼM=[[0, 0, 0],
 		[0, 0, 0],
 		[0, 0, 0]]
   [2,2]֮��, M =[[1, 1, 0],
 				[1, 1, 0],
 				[0, 0, 0]]
   [3,3]֮��, M = [[2, 2, 1],
 				[2, 2, 1],
 				[1, 1, 1]]
 * ����������ֵΪ2������4��λ��ֵΪ4������4��
 * */

public class Solution598 {
	
	/* ֻҪ�ҵ���ά����ĵ�һ���������Сֵ�͵ڶ����������Сֵ��˼���
	 * */
	
    public int maxCount(int m, int n, int[][] ops) {  
        int min_a = Integer.MAX_VALUE;  
        int min_b = Integer.MAX_VALUE;  
        for (int[] tmp : ops) {  
            if (tmp[0] < min_a)  
                min_a = tmp[0];  
            if (tmp[1] < min_b)  
                min_b = tmp[1];  
        }  
        return min_a != Integer.MAX_VALUE && min_b != Integer.MAX_VALUE ? min_a * min_b : m * n;  
    }  
}
