package hash_table;

import java.util.HashSet;
import java.util.Set;

/* 大意：
 * 集合S最初包含从1到n的数字。但不幸的是，由于数据错误，集合中的一个数字被复制到集合中的另一个数字，这导致重复一个数字并丢失另一个数字。
 * 给出一个数组nums表示错误后该集合的数据状态。你的任务是首先找到数字发生两次，然后找到缺少的数字。以数组的形式返回它们。
 * 例如：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * */

public class Solution645 {
	
	/* 两个任务，找到出现两次的数字以及找到丢失的数字。
	 * 使用Set找到重复出现的数字，使用等差数列求和公式找到丢失的数字。
	 * */
	
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return null;
        }
        Set<Integer> set = new HashSet<>();
        int dup = 0, len = nums.length;
        long sum = (len * (len + 1)) / 2;
        for (int num : nums) {
        	if (set.contains(num)) {
        		dup = num;
        	}
        	sum -= num;
        	set.add(num);
        }
        return new int[] { dup, (int)(dup + sum) };
    }
}
