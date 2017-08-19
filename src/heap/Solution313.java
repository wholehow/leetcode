package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/* ������������д����Ѱ�ҵ�n��������������.
 * ����������ָֻ����������k�������ӵ����������磬��������Ϊ4����������primes = [2, 7, 13, 19]��
 * ǰ12��������������Ϊ��[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
 * ע�⣺
 * 1.1����Ϊ�ǳ������������۸��������������б�.
 * 2.�����������б�����������.
 * 3.0 < k �� 100, 0 < n �� 10^6, 0 < primes[i] < 1000.
 * */

public class Solution313 {
	
	/* 1.����ʵ�֡���ǰn����������ȫ���ҳ����浽ugly�����С�
	 * */
	
	/*public int nthSuperUglyNumber(int n, int[] primes) {
	    int[] ugly = new int[n];
	    int[] idx = new int[primes.length];
	    ugly[0] = 1;	// ������Ŀ����һ��һ����1
	    for (int i = 1; i < n; i++) {
	        ugly[i] = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++)
	            ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
	        // ���˵������ظ���
	        for (int j = 0; j < primes.length; j++) {
	            while (primes[j] * ugly[idx[j]] <= ugly[i]) {
	            	idx[j]++;
	            }
	        }
	    }
	    return ugly[n - 1];
	}*/
	
	/* ��1�Ļ�����֮��ȥ���ظ���
	 * */
	
	/*public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        int next = 1;	// ������Ŀ����һ��һ����1
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                // ֱ�������ظ�
                if (val[j] == ugly[i]) {
                	val[j] = ugly[idx[j]++] * primes[j];
                }
                next = Math.min(next, val[j]);
            }
        }
        return ugly[n - 1];
    }*/
	
	/* �����򡣸о������������д�����ձ���д�ġ�
	 * */
	
	public int nthSuperUglyNumber(int n, int[] primes) {
	    int[] ugly = new int[n];
	    PriorityQueue<Num> pq = new PriorityQueue<>();
	    for (int i = 0; i < primes.length; i++) {
	    	pq.add(new Num(primes[i], 1, primes[i]));
	    }
	    ugly[0] = 1;	// ������Ŀ����һ��һ����1
	    for (int i = 1; i < n; i++) {
	        ugly[i] = pq.peek().val;
	        while (pq.peek().val == ugly[i]) {
	            Num nxt = pq.poll();
	            pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
	        }
	    }
	    return ugly[n - 1];
	}
	private class Num implements Comparable<Num> {
	    int val;	
	    int idx;	
	    int p;	// ������ֵ
	    public Num(int val, int idx, int p) {
	        this.val = val;
	        this.idx = idx;
	        this.p = p;
	    }
	    @Override
	    public int compareTo(Num that) {
	        return this.val - that.val;
	    }
	}
}
