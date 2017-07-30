package array;

import java.util.ArrayList;
import java.util.Arrays;

/* 给定一个可能包含重复数字的整数集合nums，返回所有可能的子集。
 * 注意：答案集不能包含重复的子集。
 * 例如：
 * 输入：nums = [1,2,2]
 * 输出：[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * */

public class Solution90 {
	
	/* 一个包含N个整数的集合的子集共有2^N个。除掉重复的就是剩下的。关键是如何找到重复的子集。
	 * 就拿[1,2,2]来说，在迭代完1之后结果集为[[], [1]]，迭代第一个2后，[[], [1], [2], [1,2]]，
	 * 接下来就要迭代重复的元素2了，此时如果遍历在迭代第一个2之前就存在的结果集元素（[[], [1]]）时，就会产生重复，
	 * 我们只能在上一轮迭代产生的新的结果中继续添加。所以要一个额外的变量来表示在结果集中的哪个位置开始遍历。
	 * */
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }
    
    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        // 子集合意味着并不需要包含所有元素，因此判断条件是<=
        // 如果pos>nums.length无返回值
        if (pos <= nums.length) {
        	res.add(new ArrayList<>(tmpRes));
        }
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i-1]) 
            	continue;   // 避免重复
            tmpRes.add(nums[i]);
            helper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}
