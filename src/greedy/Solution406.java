package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* ���⣺
 * ��������һ���������Ա�ŶӶ��С� ÿ������һ��������h��k������������h���˵ĸ߶ȣ�k�Ǿ��и߶ȴ��ڻ����h���������ǰ�������� 
 * ��дһ���ع����е��㷨��
 * ���磺
 * ���룺[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * �����[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * */

public class Solution406 {
	
	/* MSD�㷨��
	 * ���ݸ߶ȶ�������н������У�����߶���ͬ����K�����������У���
	 * ��ѡ����ߵġ����Ժ�ÿһ��Ҳ����ѡ����ߵģ�
	 * ��������һλ�߸���ʱ��ֻ��Ҫ�������ĵ�kλ
	 * �ظ���ֱ�������˶������б�
	 * */
	
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];	// h����k����
           }
        });
        List<int[]> res = new ArrayList<int[]>();
        for (int[] cur : people){
            res.add(cur[1], cur);       
        }
        return res.toArray(new int[people.length][]);
    }
}
