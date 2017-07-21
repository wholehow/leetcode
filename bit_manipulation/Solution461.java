package bit_manipulation;

/* 大意：
 * 给定两个整数x和y，求它们之间的汉明距离。
 * 汉明距离是指x和y对应的二进制相同的位取值不相同的总位数。
 * */

public class Solution461 {
	
	/* 从低位向高位比较。如果x和y的最低位不相同，也就是说x和y不相同，也就是说x和y对2取余结果肯定不同。
	 * 以此类推，求到最高位。
	 * */
	
    public int hammingDistance(int x, int y) {
        int rst = 0;
        while (x != 0 || y != 0) {
        	if (x % 2 != y % 2) {
        		rst++;
        	}
        	x >>>= 1;	// x /= 2;
        	y >>>= 1;	// y /= 2;
        }
        return rst;
    }
}
