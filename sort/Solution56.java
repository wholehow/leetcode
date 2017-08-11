package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 合并间隔。
 * 输入：[1,3],[2,6],[8,10],[15,18]
 * 输出：[1,6],[8,10],[15,18]
 * */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution56 {
	
	/* 这个题目和前面稍有不同的是合并。因为前面的排序或者其他操作必须维持原来数据不变，但是这个题目必须对数据做成更改。
	 * 所以不用重写compare方法，而是利用数组简化操作，将排序好的start和end重新合并成新的interval。
	 * */
	
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> resList = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
        	return resList;
        }
        int size = intervals.size();
        int[] starts = new int[size], ends = new int[size];
        // 关键就是用好这两个数组
        for (int i = 0; i < size; i++) {
        	starts[i] = intervals.get(i).start;
        	ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0, j = 0; i < size; i++) {	// j才是intervals数组真正的索引
        	if (i == size - 1 || starts[i + 1] > ends[i]) {	// 每次都找这样的start和end取构成新的interval
        		resList.add(new Interval(starts[j], ends[i]));
        		j = i + 1;
        	}
        }
        return resList;
    }
}
