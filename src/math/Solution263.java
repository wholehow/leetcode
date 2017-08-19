package math;

/* 大意：
 * 写一个程序来检查给出的数字是否是一个丑数。
 * 丑数是指只能被2、3、5整除的正数。比如说，6、8是丑数而14就不是丑数因为它还有7这个约数。 
 * 注意1也被看待成丑数字。
 * */

public class Solution263 {
	
	/* 分别对2、3、5去看能不能被整除，能就除一下继续判断，直到不能被2、3、5整数了为止，
	 * 看结果是不是1，是的话就是丑数了，不是则不丑。
	 * */
	
    public boolean isUgly(int num) {
        if (num <= 0) {
        	return false;
        }
        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else if (num == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
