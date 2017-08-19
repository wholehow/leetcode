package greedy;

import java.util.Arrays;
import java.util.Comparator;

/* ��������ļ��ϣ��ҵ���Ҫɾ������С���������ʹʣ��ļ�����ص���
 * ���磺
 * ���룺[ [1,2], [2,3], [3,4], [1,3] ]
 * �����1��[1,3]���Ա�ȥ��������ļ���ǲ��ص���
 * ���룺[ [1,2], [1,2], [1,2] ]
 * �����2������Ҫɾ������[1,2]��ʹ����ļ�����ص�
 * */

class Interval {
	 int start;
	 int end;
	 Interval() { start = 0; end = 0; }
	 Interval(int s, int e) { start = s; end = e; }
}

public class Solution435 {
	
	/* ����Interval����Ϣ����end��������С�ķ���ǰ�档
	 * ÿ�αȽ�i��start��i-1��end��С��
	 * */
	
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
        	return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;     //	��Ӧ��ɾ������Ŀ   

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;	// ��Щ��Ӧ��ɾ��
    }
    
    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
