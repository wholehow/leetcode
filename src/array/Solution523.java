package array;

import java.util.HashMap;
import java.util.Map;

/* �����Ǹ��������Ŀ������k��дһ����������������Ƿ�������ٳ���Ϊ2�����������У����ܺ�Ϊk�ı��������ܺ�Ϊn * k������nҲ��������
 * */

public class Solution523 {
	
	/* �������ȡ������������ǰλ��i��kȡ��Ϊx��jλ�ö�kȡ��Ϊx����ô˵��i��j֮��һ�����k����������
	 * Ϊ���ܹ������ҵ����ֶ��ڹ�ϵ������Map��Ѱ��֮ǰ�Ƿ������ͬ��������Ϊvalue��
	 * */
	
	public boolean checkSubarraySum(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>(){
	    	{
	    		put(0,-1);	// ��ʼ������Ϊ֮���õ�i-prev
	    	}
	    };
	    int runningSum = 0;
	    for (int i = 0; i < nums.length; i++) {
	        runningSum += nums[i];
	        if (k != 0) {
	        	runningSum %= k; // �ۻ�������
	        }
	        int prev = map.get(runningSum);
	        if (prev != 0) {
	            if (i - prev > 1) {	// ���֣���ǰλ��i��kȡ��Ϊx��jλ�ö�kȡ��Ϊx����ô˵��i��j֮��һ�����k��������
	            	return true;
	            }
	        }
	        else map.put(runningSum, i);
	    }
	    return false;
	}
}
