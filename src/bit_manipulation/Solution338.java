package bit_manipulation;

/* ����һ���Ǹ�����num������ÿһ������0 �� i �� num������i�����������ֵĶ����Ʊ�ʾ��1�ĸ���������������ʽ���ء�
 * ���磺
 * ���룺num = 5
 * �����[0,1,1,2,1,2]
 * */

public class Solution338 {
	
	/*public int[] countBits(int num) {
    	// ���һλ ( 1 or 0, �� " i&1 "�ȼ��� " i%2 " )
    	// ����λ( ��Ч1����Ŀ, " f[i >> 1] "�ȼ���" f[i/2] " )
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			ans[i] = ans[i >> 1] + (i & 1);
		}
		return ans;
    }*/
	
	/* highbits(n) = 1<<int(Math.log(x,2))
	 * ����highbits(n)��ʾֻ����n�����λ�õ������֡�
	 * ����ʽ��ans[n] = ans[n - highbits(n)] + 1
	 * */
	
	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			ans[i] = ans[i - (1 << (int)Math.log(i))] + 1;
		}
		return ans;
	}
}
