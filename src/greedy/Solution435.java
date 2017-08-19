package greedy;

import java.util.Arrays;
import java.util.Comparator;

/* 给定间隔的集合，找到需要删除的最小间隔数，以使剩余的间隔不重叠。
 * 例如：
 * 输入：[ [1,2], [2,3], [3,4], [1,3] ]
 * 输出：1，[1,3]可以被去除，其余的间隔是不重叠的
 * 输入：[ [1,2], [1,2], [1,2] ]
 * 输出：2，你需要删除两个[1,2]，使其余的间隔不重叠
 * */

class Interval {
	 int start;
	 int end;
	 Interval() { start = 0; end = 0; }
	 Interval(int s, int e) { start = s; end = e; }
}

public class Solution435 {
	
	/* 根据Interval的信息，对end进行排序。小的放在前面。
	 * 每次比较i的start和i-1的end大小。
	 * */
	
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
        	return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;     //	不应该删除的数目   

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;	// 这些才应该删除
    }
    
    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
