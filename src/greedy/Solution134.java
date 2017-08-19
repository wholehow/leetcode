package greedy;

/* 沿着圆形路线有N个天然气站，位置i的天然气站总数为gas[i]。
 * 你有一辆带有无限天然气罐的汽车，并且从i站到其下一站i+1的费用是cost[i]。
 * 如过你可以绕圆形路子旅行一次，返回起始加油站的索引，否则返回-1。
 * */

public class Solution134 {
	
	/* 说白了，就是问两个数组能否实现环形的收支平衡。
	 * 每次我们尽可能地去下一站（保持气体大于或等于0），直到我们不能（保持气体小于0）。
	 * 然后我们必须将起步站延伸到“最后一站”（起步站前），寻找可能的解决方案。重复这两个步骤，直到我们检查了所有的站（start == end）。
	 * 只有当剩余气体大于或等于0时，我们才能完成旅行。
	 * */
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;		// 从后往前
        int end = 0;	// 从前往后
        int remain = gas[start] - cost[start];		// 当前剩余气体总量
        while (start > end) {
           if (remain >= 0) {
              remain += gas[end] - cost[end];
              ++end;	// remain>0，说明当前位置满足条件，即end可以继续推到下一站
           }
           else {
        	   --start;
              remain += gas[start] - cost[start];
           }
        }
        return remain >= 0 ? start : -1;
     }
}
