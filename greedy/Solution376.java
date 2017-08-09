package greedy;

/* 摆动次序
 * 如果连续数字之间的差异在正和负之间严格交替，则数字序列称为摆动序列。第一个差异（如果存在）可能是正或负。具有少于两个元素的序列几乎是摆动序列。
 * 例如，[1,7,4,9,2,5]是摆动序列，因为差异（6，-3,5，-7,3）交替是正的和负的。相比之下，[1,4,7,2,5]和[1,7,4,5,5]不是摆动序列，第一个因为它的前两个差异是正的，而第二个差异是最后的差值为零。
 * 给定整数序列，返回作为摆动序列的最长子序列的长度，通过从原始序列中删除一些数量的元素（最终也为零）获得子序列，将剩余的元素保留在其原始顺序中。
 * */

public class Solution376 {
	
	/* 我们看看所谓的摆动次序就是1<7>4<9>2<5。就是大于小于关系交替存在。
	 * 因此虽然给出的是DP求解，但是用一个boolean位就可以标识出所需判断条件。
	 * */
	
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) 
        	return nums.length;
        int count = 1;
        Boolean prevInc = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && (prevInc == null || !prevInc)) {
                prevInc = true;
                count++;
            } else if(nums[i] < nums[i - 1] && (prevInc == null || prevInc)) {
                prevInc = false;
                count++;
            }
        }
        return count;
    }
}
