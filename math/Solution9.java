package math;

/* 判断一个整数是否是回文数。
 * 不使用额外的空间来完成。
 * */

public class Solution9 {
	
	/* 第一种思路
	 * 题目只说不使用额外的空间，其实我们这里可以使用String（其实我也不是很懂，单确实就是AC了）。
	 * 我们直接比较数字不太好比较，先将其转为字符串，然后依次比较字符串第一位和最后一位、第二位和倒数第二位等等的字符是不是一样的，
	 * 这里只需要比较到字符串长度一半的位置就可以了。
	 * 题目比较蛋疼的设定是，题目中只说了整数，没说是正数，而他的答案判断负数统统不是回文，即使是-121这种也不行。
	 * */
	
    /*public boolean isPalindrome(int x) {
        if (x < 0) {
        	return false;
        }
        String xStr = String.valueOf(x);
        for (int i = 0; i < xStr.length() / 2; i++) {
            if (xStr.charAt(i) != xStr.charAt(xStr.length() - 1 - i)) {
            	return false;
            }
        }
        return true;
    }*/
	
	/* 第二种思路，只要数字是末尾为0的，也就是说除以10的余数为0，就一定不是回文，因为不可能最高位是0嘛。
	 * 创建了一个整型变量来记录x从右往左读到一半时的数，
	 * 而原来的x则一步步转化成从左往右读一半的数，
	 * 最后看看两个数是不是相等，而因为有可能中间有单独一个数，所以还有可能是除以十以后相等。
	 * */
	
	/*public boolean isPalindrome(int x) {
	    if (x < 0 || ( x != 0 && x % 10 == 0)) {
	    	return false;
	    }
	    int rev = 0;
	    while (x > rev){
	    	rev = rev * 10 + x % 10;	//从右到左
	    	x = x / 10;					//从左到右
	    }
	    return (x == rev || x == rev / 10);		//有可能中间有单独一个数，所以还有可能是除以十以后相等
	}*/
	
	/* 第三种思路，我觉得是最好的。
	 * 仿照字符串回文检查方法，每次取出x的最高位和最低位比较。
	 * 这里设置一个base为10^n，用来取出最高位的数，每次循环除以100，因为每次x会消去2位。
	 * */
	
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int base = 1;
		while (x / base >= 10) {
			base *= 10;
		}
		while (x > 0) {
			int leftDigit = x / base;
			int rightDigit = x % 10;
			if (leftDigit != rightDigit) {
				return false;
			}
			x = (x % base) / 10; // x -= base * leftDigit
			base /= 100;
		}
		return true;
	}
}
