package bit_manipulation;

/* 给定整数数组，除了一个元素只出现一次外，其余每个元素都出现了三次。找到只出现一次的那个。
 * 算法应该具有线性的时间复杂性。你可以实现它而不使用额外的内存吗？
 * */

public class Solution137 {
	
	/* 利用计算机按位储存数字的特性。
	 * 我们可以建立一个32位的数字，来统计每一位上1出现的个数，我们知道如果某一位上为1的话，那么如果该整数出现了三次，对3取余为0，
	 * 我们把每个数的对应位都加起来对3取余，最终剩下来的那个数就是单独的数字。
	 * */
	
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
        	int bitCount = 0;
        	for (int num : nums) {
        		bitCount += (num >> i) & 1;
        	}
        	res |= (bitCount % 3) << i;
        }
        return res;
    }
    
    /* 用3个整数来表示INT的各位的出现次数情况，ones表示出现了1次，twos表示出现了2次。当出现3次的时候该位清零。最后答案就是ones的值。
     * 1.ones代表第i位只出现一次的掩码变量
     * 2.twos代表第i位只出现两次的掩码变量
     * 3.threes代表第i位只出现三次的掩码变量
     * */
    
    /*public int singleNumber(int[] nums) {
    	int ones = 0, twos = 0, threes = 0;
    	for (int i = 0; i < nums.length; i++) {
    		twos |= ones & nums[i];
    		ones ^= nums[i];
    		threes = ones & twos;
    		ones &= ~threes;
    		twos &= ~threes;
    	}
    	return ones;
    }*/
}
