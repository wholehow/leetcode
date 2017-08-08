package hash_table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 给定一棵二叉树，求其最频繁子树和。即所有子树的和中，出现次数最多的数字。如果存在多个次数一样的子树和，则全部返回。
 * */

public class Solution508 {
	
	/* 1.获取每个子树的总和sum，向map添加sum及其频率freq。
	 * 2.每次试图获取最大的freq。如果当前sum的freq大于之前的freq，将resList进行clear并添加当前sum作为新的key，value设置为1。
	 * 3.helper递归处理root的左右子树，当所有的结点都处理完，此时将resList的内容取出来放到int数组中，即可得到最终结果。
	 * 4.注意最后的输出顺序
	 * */
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	List<Integer> resList = new ArrayList<Integer>();
	private int freq = 0;
	
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];	// 不接受null输出也是醉了
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
