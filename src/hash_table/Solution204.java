package hash_table;

/* Ѱ������С��n��������
 * */

public class Solution204 {
	
	/* ����֪����򵥵���������2��3��5����������ô��������������أ�
	 * ����ʵ��Ҫ��΢תһ���䣬���n����������ôn������k����k>=2��һ������������
	 * ֻ��Ҫ��ÿ����������ʱ������С��n�ı�������Ϊ�������������ͱ�����ÿ������һ������Ҫ��֮ǰ��������ȥ��һ�飬��󽵵���ʱ�临�Ӷȡ�
	 * */
	
    public int countPrimes(int n) {
        int res = 0;
        boolean[] notPrime  = new boolean[n];
        for (int i = 2; i < n; i++) {
        	if (notPrime[i] == false) {
        		res++;
        		for (int j = 2; j * i < n; j++) {
        			notPrime[j * i] = true;
        		}
        	}
        }
        return res;
    }
}
