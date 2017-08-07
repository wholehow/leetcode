package math;

/* ���������㡣
 * ���������Ǽ���a^b mod 1337������a����������b����������ʽ�����ļ������������
 * ���磺
 * ����:a = 2 b = [3]
 * �����8
 * ���룺a = 2 b = [1,0]
 * �����1024
 * */

public class Solution372 {
	
	/* 1.a^b % 1337 = (a%1337)^b % 1337 = x ^ b % 1337
	 * 2.xy % 1337 = ((x%1337) * (y%1337)) % 1337
	 * ���е�һ����ʽ������������a��ֵ, �ڶ�����ʽ���Խ�����һλλ�ļ���
	 * ��ʵֻ�õ���һ����ʽ�Ϳ�������㷨���
	 * */
	
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;	// ���a��������1337����ʵ��û�м���ı�Ҫ�ˣ�ֱ�����0
        a = a % 1337;	// ��ʽ1�е�x
        int[] next = new int[1337];
        int count = 0;
        int val = a;
        while (next[val] == 0) {	// ע�������ѭ����������ʼ����Щλ����0�ģ�����x��˵��һ��1337��С�����飬�������ڶ����ֿ��ܷŴ�x�����������������ˣ�
            next[val] = val * a % 1337;
            val = next[val];
            count++;
        }
        int m = mod(b, count);
        while (--m > 0)
            a = next[a];
        return a;
    }

    private int mod(int[] b, int c) {
        int m = 0;
        for (int i = 0; i < b.length; i++) {
            m = (m * 10 + b[i]) % c;
        }
        return m;
    }
}
