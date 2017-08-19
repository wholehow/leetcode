package bit_manipulation;

/* ���⣺
 * дһ����������ȡһ���޷�����������������ӵ�еġ�1��bits�ĸ�����Ҳ��ΪHamming weight���� 
 * ���磬32λ��������11�������Ʊ�ʾΪ00000000000000000000000000001011�����Ժ���Ӧ�÷���3
 * */

public class Solution191 {
	
	/* ÿ�ν����޷�������һλ��������ұߵ�bit�Ƿ�Ϊ1������ͳ�ơ�
	 * */
	
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
        	res += n & 1;
        	n >>>= 1;
        }
        return res;
    }
    
    /* ÿ�ν���n & (n - 1)�������Ϳ��Ժ��Ե�bitλɽΪ0�Ĳ��֡�
     * n & (n - 1)����ʵ������Ĩ�����ұߵ�1��
     * n & (-n + 1)����ʵ����Ҳ��Ĩ�����ұߵ�1
     * */
    
    /*public int hammingWeight(int n) {
    	int res = 0;
    	while (n != 0) {
    		n &= (n - 1);
    		// n -= n & (-n + 1);
    		res++;
    	}
    	return res;
    }*/
    
    /* ����Ȼ�ⷨ����ƽ���㷨
     * ͦ�����ģ�����Ȥ�Ŀ�������һ�¹���
     * */
    
    /*public int hammingWeight(int n) {
    	n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
    	n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
    	n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
    	n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
    	n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
    	return n;
    }*/  
}
