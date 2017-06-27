package array;


/* ���⣺
 * ʵ��MATLAB��reshape�������ܡ�
 * ����һ����ά���飬����������r��c������r����������c����������
 * 
 * ���磺
 * ���룺nums = [[1,2], [3,4]] r = 1, c = 4
 * �����[[1,2,3,4]]
 * 
 * ���룺nums = [[1,2], [3,4]] r = 2, c = 4
 * �����[[1,2],[3,4]]
 * */

public class Solution566 {
	
	/* ���ֶ�ά�����С���·��������Ĺؼ����Ƕ�Ӧλ�õ�����ת����
	 * ��ֱ�ӵİ취�����Ȱ�ԭ������ֱ�����һ��ֱ�ߣ�Ȼ��������µ����顣
	 * */
	
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (nums == null || m == 0) {
            return null;
        }
        if (m * n != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }
        return res;
    }
}
