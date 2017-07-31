package bit_manipulation;

/* 求解汉明距离之和。
 * 例如：
 * 输入：4, 14, 2
 * 输出：6，在二进制表示中，4是0100，14是1110，而2是0010（只是 在这种情况下显示四位相关）。
 * 所以答案是： 汉明距离（4,14）+汉明距离（4,2）+汉明距离（14,2）= 2 + 2 + 2 = 6。
 * */

public class Solution477 {
	
	/* 对于32位整数，我们可以分开计算每次只计算一位。例如，每次只计算nums中每个数字的最低位。
	 * 假设nums中有i个数最低位为0，有j个数最低位为1。通过异或操作，一定可以得到最低位为1的数。
	 * 那么这样的数有多少种组合呢？很明显是i*j0种。因此我们可以认为当前位对于最后结果的贡献度就是i*j。
	 * */
	
    public int totalHammingDistance(int[] nums) {
        int n = 31;	// 32位整数
        int len = nums.length;
        int[] bitCounts = new int[n];	// 注意数组大小是根据int的类型而不是nums的长度
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                bitCounts[j] += (nums[i] >> j) & 1;
            }
        }
        int sum = 0;
        for (int count: bitCounts) {
        	// 当前位对于最后结果的贡献度就是i*j
            sum += count * (len - count);
        }
        return sum;
    }
}
