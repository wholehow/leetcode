package math;

/* 大意：
 * 在无限整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 中找到第n个数字。
 * 注意： n是个正数而且会在32位范围内（n<2的31次方）。
 * 
 * 例如：
 * 输入：3 
 * 输出：3
 * 
 * 输入：11 
 * 输出：0 解释：序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 的第11个数是数字10中的0。
 * */

public class Solution400 {
	
	/* 我们首先来分析自然数序列和其位数的关系，
	 * 前9个数都是1位的，然后10到99总共90个数字都是两位的，100到999这900个数都是三位的。
	 * 那么这就很有规律了，我们可以定义个变量cnt，初始化为9，然后每次循环扩大10倍，
	 * 再用一个变量len记录当前循环区间数字的位数，
	 * 另外再需要一个变量start用来记录当前循环区间的第一个数字，
	 * 我们n每次循环都减去len*cnt (区间总位数)，当n落到某一个确定的区间里了，
	 * 那么(n-1)/len就是目标数字在该区间里的坐标，加上start就是得到了目标数字，
	 * 然后我们将目标数字start转为字符串，(n-1) % len就是所要求的目标位
	 * */
	
    public int findNthDigit(int n) {
    	long cnt = 9;	//这里请务必使用long，否则会发生越界错
    	int len = 1;
    	int start = 1;
        while (n > len * cnt) {
            n -= len * cnt;
            len++;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }  
}
