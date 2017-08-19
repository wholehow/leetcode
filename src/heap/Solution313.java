package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/* 超级丑数。编写程序寻找第n个“超级丑数”.
 * 超级丑数是指只包含给定的k个质因子的正数。例如，给定长度为4的质数序列primes = [2, 7, 13, 19]，
 * 前12个超级丑数序列为：[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
 * 注意：
 * 1.1被认为是超级丑数，无论给定怎样的质数列表.
 * 2.给定的质数列表以升序排列.
 * 3.0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000.
 * */

public class Solution313 {
	
	/* 1.数组实现。将前n个超级丑数全都找出来存到ugly数组中。
	 * */
	
	/*public int nthSuperUglyNumber(int n, int[] primes) {
	    int[] ugly = new int[n];
	    int[] idx = new int[primes.length];
	    ugly[0] = 1;	// 根据题目，第一个一定是1
	    for (int i = 1; i < n; i++) {
	        ugly[i] = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++)
	            ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
	        // 过滤掉可能重复的
	        for (int j = 0; j < primes.length; j++) {
	            while (primes[j] * ugly[idx[j]] <= ugly[i]) {
	            	idx[j]++;
	            }
	        }
	    }
	    return ugly[n - 1];
	}*/
	
	/* 在1的基础上之际去掉重复的
	 * */
	
	/*public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        int next = 1;	// 根据题目，第一个一定是1
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                // 直接跳过重复
                if (val[j] == ugly[i]) {
                	val[j] = ugly[idx[j]++] * primes[j];
                }
                next = Math.min(next, val[j]);
            }
        }
        return ugly[n - 1];
    }*/
	
	/* 堆排序。感觉这个方法不好写，参照别人写的。
	 * */
	
	public int nthSuperUglyNumber(int n, int[] primes) {
	    int[] ugly = new int[n];
	    PriorityQueue<Num> pq = new PriorityQueue<>();
	    for (int i = 0; i < primes.length; i++) {
	    	pq.add(new Num(primes[i], 1, primes[i]));
	    }
	    ugly[0] = 1;	// 根据题目，第一个一定是1
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
	    int p;	// 素数的值
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
