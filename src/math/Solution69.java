package math;

/* �Լ�ʵ�ֺ�����ƽ������
 * */

public class Solution69 {
	
	/* ���ַ�
	 * ����˼·�����ֲ������ƣ�Ҫ��֪������ķ�Χ��ȡ����߽���ұ߽磬Ȼ��ÿ�ο���������������һ�룬ֱ�������ҽ�������
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
	
	/* ��ţ�ٷ����ο�wikipedia�ͰٶȰٿơ�
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
