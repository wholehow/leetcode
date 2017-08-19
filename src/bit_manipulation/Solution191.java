package bit_manipulation;

/* 大意：
 * 写一个函数，获取一个无符号整型数并返回它拥有的‘1’bits的个数（也称为Hamming weight）。 
 * 比如，32位整型数‘11’二进制表示为00000000000000000000000000001011，所以函数应该返回3
 * */

public class Solution191 {
	
	/* 每次进行无符号右移一位，检查最右边的bit是否为1来进行统计。
	 * */
	
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
        	res += n & 1;
        	n >>>= 1;
        }
        return res;
    }
    
    /* 每次进行n & (n - 1)操作，就可以忽略掉bit位山为0的部分。
     * n & (n - 1)操作实际上是抹掉最右边的1。
     * n & (-n + 1)操作实际上也是抹掉最右边的1
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
    
    /* 超自然解法——平行算法
     * 挺难理解的，有兴趣的可以搜索一下过程
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
