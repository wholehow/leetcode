package array;

/*
 	大意：
	给出一个非空整型数组，返回数组中第三大的数。如果不存在，就返回最大的数。时间复杂度必须为O（n）。
	
	例1：
	输入：[3, 2, 1]
	输出：1
	解释：第三大的数为1。
	
	例2：
	输入：[1, 2]
	输出：2
	解释：不存在第三大的数，所以要用最大的数 2 来代替。
	
	例3：
	输入：[2, 2, 3, 1]
	输出：1
	解释：注意这里第三大的数是指区分的数字。两个 2 都被视为第二大的数。
*/

public class Solution414 {
	
	/* 由于只能遍历一遍来寻找第三大的数，我们使用三个整形变量
	 * firstMax，secondMax，thirdMax
	 * 来依次记录当前遍历到位置i的时刻，暂存的前三大的整数。
	 * 我们以数组中第一个数字来作为初始值，
	 * 1.如果当前数字比第一个数字大，那么原本第一个数字的值要移动到第二个，原本第二个数字的值要移动到第三个；
	 * 2.如果替代的是第二个数字，同样要把原本第二个数字的值移动到第三个。
	 * 3.由于我们是用第一个数字作为初始值的，因此在替换数字时还有一个原因就是如果第二个和第三个数字还是初始值，
	 * 而出现了与初始值不同的数字，那就不要求比原数字大了，直接替换并后移，
	 * 否则如果第一个数字最大，那即使有第三大数字也不会记录下来。
	 * 4.最后要判断三个数字是不是不一样，不一样才返回第三大数字，否则就要返回最大的数字。
	 */
	
	public int thirdMax(int[] nums) {
		
		//暂存前三大的整型变量初始值为nums[0]
        int firstMax = nums[0];
        int secondMax = nums[0];
        int thirdMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > firstMax) {	//1.
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] != firstMax && (nums[i] > secondMax || secondMax == firstMax)) {		//2.
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if ((nums[i] != firstMax && nums[i] != secondMax) 
            		&& (nums[i] > thirdMax || thirdMax == secondMax || thirdMax == firstMax)) {		//3.
                thirdMax = nums[i];
            }
        }
        if (firstMax > secondMax && secondMax > thirdMax) {		//4.
        	return thirdMax;
        } else {
       	 	return firstMax;
        }
	}
}
