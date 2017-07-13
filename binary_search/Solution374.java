package binary_search;

/* 大意：
 * 我们来玩猜数字游戏。游戏规则如下：
 * 我挑选一个1到n之间的数字。你来猜我选的是哪个数字。
 * 每一次你猜错，我都会告诉你数字高了还是低了。
 * 你可以调用一个预定义的API guess(int num)，返回3种结果 (-1, 1, 或 0)：
 * -1 : 我的数字更低
 	1 : 我的数字更高
 	0 : 恭喜你！猜对了！
 * */

/* The guess API is defined in the parent class GuessGame.
	@param num, your guess
	@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   		int guess(int num); */

public class Solution374 {
	
	/* 这道题是一道典型的猜价格的问题，根据对方说高了还是低了来缩小范围，最简单快速的方法就是折半搜索法，原理很简单。
	 * */
	
    public int guessNumber(int n) {
        if (guess(n) == 0) {
        	return n;
        }
        int left = 1, right = n;
        while (left < right) {
        	int mid = left + (right - left) / 2;
        	int tmp = guess(mid);
        	if (tmp == 0) {
        		return mid;
        	} else if (tmp == 1) {
        		left = mid;
			} else {
				right = mid;
			}
        }
        return left;
    }	
}
