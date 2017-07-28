package array;

import java.util.ArrayList;
import java.util.List;

/* 给出一个序号k，返回杨辉三角形的第k行。
 * 比如给出 k = 3， 返回 [1,3,3,1]。
 */

public class Solution119 {
	
	/* 常规的思路就是在118的基础上进行修改，只返回第rowIndex行的ArrayList。
	 * */
	
    /*public List<Integer> getRow(int rowIndex) {
    	if (rowIndex < 0) {
    		return new ArrayList<Integer>();
    	}
        List<Integer> resList = new ArrayList<Integer>();
        resList.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(1);
            for (int j = 1; j < i; j++) {
                newList.add(resList.get(j-1) + resList.get(j));
            }
            newList.add(1);
            resList = newList;
        }
        return resList;
    }*/
	
	/* 突然想到DP中使用到的矩阵压缩思想。
	 * 
	 * 让我们来看看杨辉三角是如何形成的。
	 * 第k层有k个元素
	 * 每层第一个以及最后一个元素值为1
	 * 对于第k（k > 2）层第n（n > 1 && n < k）个元素A[k][n]，A[k][n] = A[k-1][n-1] + A[k-1][n]
	 * 
	 * 究其本质，每个位置的数要么是1，要么是上一层的1逐渐累加到当前行。
	 * 也就是说，每个位置的数都是若干个1的组合，而且杨辉三角是严格对称的。
	 * 这就为我们下面这种解法提供了保障。
	 * */
	
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> resList = new ArrayList<Integer>();
		//在0的位置添上1：[1]，此时为第一行，不满足则继续；
		//不执行小循环，继续0的位置添上1：[1, 1]，此时为第二行，不满足则继续； 
		//不执行小循环，继续0的位置添上1：[1, 1, 1]，执行小循环，得[1, 2, 1]，此时为第三行，不满足则继续；
		//此时继续0的位置添上1：[1, 1, 2, 1]，执行小循环，得[1, 3, 3, 1，此时为第四行，不满足则继续；
		// ……
		//这样下去确实可以得到每一行的数据，其实就是在一个List内模拟杨辉三角的性质
		for (int i = 0; i <= rowIndex; i++) {
			resList.add(0, 1);
			for (int j = 1; j < resList.size() - 1; j++) {
				resList.set(j, resList.get(j) + resList.get(j + 1));
			}
		}
		return resList;
	}
}
