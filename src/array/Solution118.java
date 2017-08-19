package array;

import java.util.ArrayList;
import java.util.List;

/* ������� ����˹�����ǣ�
 * 
 * ���磺
 * ���� numRows = 5������
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * */

public class Solution118 {
	
	/* ��k����k��Ԫ��
	 * ÿ���һ���Լ����һ��Ԫ��ֵΪ1
	 * ���ڵ�k��k > 2�����n��n > 1 && n < k����Ԫ��A[k][n]��A[k][n] = A[k-1][n-1] + A[k-1][n]
	 * �㷨ʱ�临�Ӷ�Ӧ����O(1 + 2 + 3 + ... + n) = O(n ^ 2)
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
