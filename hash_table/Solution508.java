package hash_table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* ����һ�ö�������������Ƶ�������͡������������ĺ��У����ִ����������֡�������ڶ������һ���������ͣ���ȫ�����ء�
 * */

public class Solution508 {
	
	/* 1.��ȡÿ���������ܺ�sum����map���sum����Ƶ��freq��
	 * 2.ÿ����ͼ��ȡ����freq�������ǰsum��freq����֮ǰ��freq����resList����clear����ӵ�ǰsum��Ϊ�µ�key��value����Ϊ1��
	 * 3.helper�ݹ鴦��root�����������������еĽ�㶼�����꣬��ʱ��resList������ȡ�����ŵ�int�����У����ɵõ����ս����
	 * 4.ע���������˳��
	 * */
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	List<Integer> resList = new ArrayList<Integer>();
	private int freq = 0;
	
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];	// ������null���Ҳ������
        helper(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
        	res[i] = resList.get(i);
        }
        return res;
    }
	
	private void helper(TreeNode root) {
		if (root == null) return;
		int sum = calcuSum(root);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		if (map.get(sum) == freq) {
			resList.add(sum);
		} else if (map.get(sum) > freq) {
			resList.clear();
			resList.add(sum);
		}
		freq = Math.max(freq, map.get(sum));
		helper(root.left);
		helper(root.right);
	}
	
	private int calcuSum(TreeNode root) {
		int sum = root.val;
		if (root.left != null) sum += calcuSum(root.left);
		if (root.right != null) sum += calcuSum(root.right);
		return sum;
	}
}
