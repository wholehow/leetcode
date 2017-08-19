package binary_search;

import java.util.Arrays;

/* ���⣺
 * ����Ҫ���ˣ���������ĵ�һ�����������Ƽ�������ů���ݡ�
 * ����һ��������ˮƽ���ϵķ��ݺͼ�������������С�ļ������뾶��ʹ�����з��ݶ����Ա����ǡ�
 * ���뷿�ݺͼ����������꣬��������ļ������뾶����Сֵ��
 * ע�⣺
 * 1.���ݺͼ���������Ŀ��Ϊ�Ǹ����������Ҳ�����25000
 * 2.���ݺͼ�������λ���ǷǸ����������Ҳ�����10^9
 * 3.λ�ڼ������뾶��Χ�ڵķ��ݾ��ɱ�����
 * 4.�������İ뾶����һ����
 * 
 * ���磺
 * ���룺[1,2,3],[2]
 * �����1������ֻ��λ��2�����˼�����������ʹ�ð뾶1�Ϳ��Լ������еķ���
 * 
 * ���룺[1,2,3,4],[1,4]
 * �����1��������λ��1��4�����˼�������ʹ�ð뾶1���ɼ������еķ���
 * */

public class Solution475 {
	
	/* ��ÿ��house����ߺ��ұ��ҵ������ȡů����Ȼ������ߺ��ұߵ�ȡů�����ҳ�����С�뾶��
	 * �����������house����С�뾶�У��ҳ�һ�����ֵ���Ϳ��Ա�֤����house����ȡů�ˡ�
	 * �������������飬��ʾÿ��house����ߺ��ұ�ȡů��������
	 * */
	
	/*public int findRadius(int[] houses, int[] heaters) {
	    Arrays.sort(houses);
	    Arrays.sort(heaters);

	    int left = 0, right = heaters.length - 1;
	    int[] lefts = new int[houses.length];
	    int[] rights = new int[houses.length];
	    for (int i = 0; i < houses.length; i++) {
	        while (left < heaters.length && heaters[left] <= houses[i]) {	//ע������left���ж�����
	            lefts[i] = left + 1;
	            left++;
	        }
	        left = lefts[i] != 0 ? (lefts[i] - 1) : 0;
	        while (right >= left && heaters[right] >= houses[i]) {	//ע������right���ж�����
	            rights[i] = right + 1;
	            right--;
	        }
	        right = heaters.length - 1;
	    }
	    
	    int res = 0;
	    for (int i = 0; i < houses.length; i++) {
	        int min = Integer.MAX_VALUE;
	        if (lefts[i] != 0) {
	            min = Math.min(houses[i] - heaters[lefts[i] - 1], min);
	        }
	        if (rights[i] != 0) {
	            min = Math.min(heaters[rights[i] - 1] - houses[i], min);
	        }
	        res = Math.max(min, res);
	    }
	    
	    return res;
	}*/
	
	/* ���ǿ����ö��ֲ��ҷ��������ҵ���һ�����ڵ��ڵ�ǰhouseλ�õ�����
	 * �����������ڣ���ô���ǿ���������house�Ĳ�ֵ������������������heater�������֣����ǿ������house��ǰ��һ�����Ĳ�ֵ��
	 * ����������ȡ��С��Ϊcover��ǰhouse����С�뾶��Ȼ������ÿ�θ��½��res����
	 * */
	
	public int findRadius(int[] houses, int[] heaters) {
	    Arrays.sort(heaters);
	    int res = 0;

	    for (int house : houses) {
	        int index = Arrays.binarySearch(heaters, house);
	        if (index < 0) {
	            index = ~index;
	            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
	            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

	            res = Math.max(res, Math.min(dist1, dist2));
	        }
	    }

	    return res;
	}
}
