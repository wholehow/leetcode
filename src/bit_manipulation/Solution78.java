package bit_manipulation;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/* ����:
 * ����һ�鲻ͬ��������nums���������п��ܵ��Ӽ���
 * */

public class Solution78 {
	
	/* һ������N�������ļ��ϵ��Ӽ�����2^N����
	 * ��ʼsubset��Ϊ��[]
	 * ���S0��Ϊ��[], [S0]
	 * ���S1��Ϊ��[], [S0], [S1], [S0, S1]
	 * ���S2��Ϊ��[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]
	 * */
	
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null) {
        	return resList;
        }
        // ��һ��[]
        resList.add(new ArrayList<>());
        Arrays.sort(nums);
        // for-each
        for (int num : nums) {
        	List<List<Integer>> tmp = new ArrayList<>();
        	for (List<Integer> sub : resList) {
        		List<Integer> aList = new ArrayList<>(sub);
        		aList.add(num);
        		tmp.add(aList);
        	}
        	resList.addAll(tmp);
        }
        return resList;
    }
}
