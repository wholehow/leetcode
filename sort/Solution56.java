package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* �ϲ������
 * ���룺[1,3],[2,6],[8,10],[15,18]
 * �����[1,6],[8,10],[15,18]
 * */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution56 {
	
	/* �����Ŀ��ǰ�����в�ͬ���Ǻϲ�����Ϊǰ����������������������ά��ԭ�����ݲ��䣬���������Ŀ������������ɸ��ġ�
	 * ���Բ�����дcompare������������������򻯲�����������õ�start��end���ºϲ����µ�interval��
	 * */
	
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> resList = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
        	return resList;
        }
        int size = intervals.size();
        int[] starts = new int[size], ends = new int[size];
        // �ؼ������ú�����������
        for (int i = 0; i < size; i++) {
        	starts[i] = intervals.get(i).start;
        	ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0, j = 0; i < size; i++) {	// j����intervals��������������
        	if (i == size - 1 || starts[i + 1] > ends[i]) {	// ÿ�ζ���������start��endȡ�����µ�interval
        		resList.add(new Interval(starts[j], ends[i]));
        		j = i + 1;
        	}
        }
        return resList;
    }
}
