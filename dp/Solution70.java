package array;

/* ���⣺
 * ������һ��¥�ݡ���Ҫn��¥�ݵ��ﶥ���� ÿ���������һ�ڻ�������¥�ݡ����ܹ��ж��������������ķ�����
 * */
	
public class Solution70 {
	
	/* ��������һ��Ҫ����˼����
	 * ������res[n]��������������������ôres[n]����εó����أ�
	 * ֻ������res[n - 1]��һ������res[n - 2]����������֮����
	 * res[n] = res[n - 1] + res[n - 2]
	 * */
	
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
    
    /* ����ʡ�ռ������ */
    /*public int climbStairs(int n) {
        if (n < 4) return n;  
        int a = 2, b = 3, c = 5;  
        for (int i = 5; i <= n; i++)  
        {  
            a = c;  
            c = b+c;  
            b = a;  
        }  
        return c;  
    }*/
}
