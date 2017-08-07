package math;

/* 超级幂运算。
 * 您的任务是计算a^b mod 1337，其中a是正整数，b是以数组形式给出的极大的正整数。
 * 例如：
 * 输入:a = 2 b = [3]
 * 输出：8
 * 输入：a = 2 b = [1,0]
 * 输出：1024
 * */

public class Solution372 {
	
	/* 1.a^b % 1337 = (a%1337)^b % 1337 = x ^ b % 1337
	 * 2.xy % 1337 = ((x%1337) * (y%1337)) % 1337
	 * 其中第一个公式可以用来削减a的值, 第二个公式可以将数组一位位的计算
	 * 其实只用到第一个公式就可以完成算法设计
	 * */
	
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;	// 如果a可以整除1337，其实就没有计算的必要了，直接输出0
        a = a % 1337;	// 公式1中的x
        int[] next = new int[1337];
        int count = 0;
        int val = a;
        while (next[val] == 0) {	// 注意这里的循环条件，初始化那些位置是0的（对于x来说，一个1337大小的数组，究竟存在多少种可能放大x倍后他就满足条件了）
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
