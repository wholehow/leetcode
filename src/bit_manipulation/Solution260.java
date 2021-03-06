package bit_manipulation;

/* 给定一个数字数字的数组，其中有两个元素只出现一次，所有其他元素出现两次。找到只出现一次的两个元素。
 * */

public class Solution260 {

	/* 如果只有a和b出现了一次其余都出现了两次，那么所有数最后异或的结果就是a^b。
	 * 因为a和b是不同的，所以一定可以找到第k位，假设a的第k位为0，那么b的第k位一定是1。
	 * 接下来再遍历一次数组，这次只与第k位上是1的数异或，其他的数忽略。那么第二次遍历结束后，异或结果
	 * 就是a或b中的一个，假设是b，再与a^b异或一次就得到a。
	 * */
	
	public int[] singleNumber(int[] nums) {
	    int[] res = new int[2];        
	    int xor = 0;
	    for (int num : nums)
	    {
	        xor ^= num;
	    }
	    int rightMost = xor & ~(xor - 1);	// 寻找最右侧的1
	    // int bit = xor & (~xor + 1);
	    int num1 = 0, num2 = 0;
	    for (int num : nums)
	    {
	        if ((num & rightMost) > 0)
	        {
	            num1 ^= num;
	        } else
	        {
	            num2 ^= num;
	        }
	    }
	    res[0] = num1;
	    res[1] = num2;
	    return res;
	}
}
