package math;

/* 自己实现函数求平方根。
 * */

public class Solution69 {
	
	/* 二分法
	 * 基本思路跟二分查找类似，要求知道结果的范围，取定左边界和右边界，然后每次砍掉不满足条件的一半，直到左界和右界相遇。
	 * */
	
	/*public int mySqrt(int x) {  
	    if (x < 0) {
	    	return -1; 
	    }
	    if (x == 0) {
	    	return 0;  
	    }
	    int left = 1;  
	    int right = x / 2 + 1;  
	    while (left <= right)  
	    {  
	        int mid = (left + right) / 2;  
	        if(mid <= x / mid && x / (mid + 1) < (mid + 1))  
	            return mid;  
	        if (x / mid < mid)  
	        {  
	            right = mid - 1;  
	        } else {  
	            left = mid + 1;  
	        }  
	    }  
	    return 0;  
	} */
	
	/* 拟牛顿法，参考wikipedia和百度百科。
	 * */
	
	public int mySqrt(int x) {  
	    if (x < 0) {
	    	return -1; 
	    }
	    if (x == 0) {
	    	return 0;  
	    }  
	    double lastY = 0;  
	    double y = 1;  
	    while (y != lastY)  
	    {  
	        lastY = y;  
	        y = (y + x / y) / 2;  
	    }  
	    return (int)(y);  
	}  
}
