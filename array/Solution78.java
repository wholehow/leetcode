package array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/* 大意:
 * 给定一组不同的整数，nums，返回所有可能的子集。
 * */

public class Solution78 {
	
	/* 一个包含N个整数的集合的子集共有2^N个。
	 * 起始subset集为：[]
	 * 添加S0后为：[], [S0]
	 * 添加S1后为：[], [S0], [S1], [S0, S1]
	 * 添加S2后为：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]
	 * */
	
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null) {
        	return resList;
        }
        // 第一个[]
        resList.add(new ArrayList<>());
        Arrays.sort(nums);
        // for-each
        for (int num : nums) {
        	List<List<Integer>> tmp = new ArrayList<>();
        	for (List<Integer> sub : resList) {
        		List<Integer> aList = new ArrayList<>(sub);
        		aList.add(num);
        		tmp.add(aList);
        	}
        	resList.addAll(tmp);
        }
        return resList;
    }
}
