package math;

/* 大意：
 * 给定整数数组A，长度为n。假设Bk是通过旋转阵列A k位置得到的阵列，我们在A上定义一个“旋转函数”F，如下所示：
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 * 计算F(0)，F(1)，...，F(N-1)中的最大值。
 * 例如：
 * A = [4, 3, 2, 6]
 *  F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
	F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
	F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
	F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 最大值为26。
 * */

public class Solution396 {
	
	/* 我们为了找规律，先把具体的数字抽象为A,B,C,D，那么我们可以得到：
	 * F(0) = 0A + 1B + 2C +3D
	 * F(1) = 0D + 1A + 2B +3C
	 * F(2) = 0C + 1D + 2A +3B
	 * F(3) = 0B + 1C + 2D +3A
	 * 那么，我们通过仔细观察，我们可以得出下面的规律：
	 * F(1) = F(0) + sum - 4D
	 * F(2) = F(1) + sum - 4C
	 * F(3) = F(2) + sum - 4B
	 * 那么我们就找到规律了, F(i) = F(i-1) + sum - n*A[n-i]
	 * */
	
    public int maxRotateFunction(int[] A) {
    	if (A == null || A.length == 0) return 0;
    	int sum = 0;	// 所有数的和
    	int len = A.length;
    	int F = 0;
    	for (int i = 0; i < len; i++) {
    	    F += i * A[i];
    	    sum += A[i];
    	}
    	int max = F;
    	for (int i = len - 1; i >= 1; i--) {
    	    F = F + sum - len * A[i];	// 根据规律计算当前F值
    	    max = Math.max(F, max);
    	}
    	return max;  
    }
}
