package array;

import java.util.ArrayList;
import java.util.List;

/* 杨辉三角 （帕斯卡三角）
 * 
 * 例如：
 * 给定 numRows = 5，返回
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * */

public class Solution118 {
	
	/* 第k层有k个元素
	 * 每层第一个以及最后一个元素值为1
	 * 对于第k（k > 2）层第n（n > 1 && n < k）个元素A[k][n]，A[k][n] = A[k-1][n-1] + A[k-1][n]
	 * 算法时间复杂度应该是O(1 + 2 + 3 + ... + n) = O(n ^ 2)
	 * */
	
    public List<List<Integer>> generate(int numRows) {
    	if (numRows == 0) {
    		return new ArrayList<List<Integer>>();
    	}
    	List<List<Integer>> resLists = new ArrayList<List<Integer>>();
    	List<Integer> preList = new ArrayList<Integer>();
    	preList.add(1);
    	resLists.add(preList);
    	for (int i = 1; i < numRows; i++) {
    		List<Integer> newList = new ArrayList<Integer>();
    		newList.add(1);
    		for (int j = 1; j < i; j++) {
    			newList.add(preList.get(j - 1) + preList.get(j));
    		}
    		newList.add(1);
    		resLists.add(newList);
    		preList = newList;
    	}
    	return resLists;
    }
}
