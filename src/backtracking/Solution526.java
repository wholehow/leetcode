package backtracking;

/* �������1��N�����У���i�����������й���֮һ����Ƹ�����Ϊ���������С�
 * 1.��i��λ�õ����ֿ��Ա�i����
 * 2.i���Ա���i��λ�õ���������
 * ��������N�����ж��ٸ���������
 * ���磺
 * ����:2
 * �����2
 * ��һ������������[1, 2]
 * 1���Ա�λ��1������2���Ա�λ�ö�����
 * �ڶ�������������[2, 1]
 * ͬ��
 * */

public class Solution526 {
	
	/* ����������
	 * ������������Ϊ��helper(N, idx, visited)
	 * ����idxΪ��ǰ���ֵ��±�visitedΪ��ǰλ���Ƿ񱻷��ʹ�
	 * ��ʼ��idx = 1, nums = [1 .. N]
	 * ����nums���ǵ�ǰ����Ϊn��visited��Ϊtrue
	 * ��n���������������������helper(idx + 1, nums)�ۼ����𰸣�visited��Ϊfalse
	 * */
	
    public int countArrangement(int N) {
        return helper(N, 1, new boolean[N + 1]);
    }
    private int helper(final int N, int idx, boolean[] visited) {
    	if (idx > N) return 1;
    	int res = 0;
    	for (int i = 1; i <= N; i++) {
			if (!visited[i] && (i % idx == 0 || idx % i == 0)) {
				visited[i] = true;
				res += helper(N, idx + 1, visited);
				visited[i] = false;
			}
		}
    	return res;
    }
}
