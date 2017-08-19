package tree;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* ���⣺
 * ����һ�÷ǿյĶ����������������ʽ����ÿ��ڵ��ƽ��ֵ��
 * ���磺
 * ���룺
 *  3
   / \
  9  20
    /  \
   15   7	
 * �����[3, 14.5, 11]
 * */

public class Solution637 {
	
	/* �����Ե�BFS����˵�ǲ�α�����
	 * */
	
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	if (root == null) {
        	return resList;
        }
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		double sum = 0.0;
    		TreeNode node = null;
    		for (int i = 0; i < size; i++) {
    			node = queue.poll();
    			sum += node.val;
    			if (node.left != null) queue.offer(node.left);
    			if (node.right != null) queue.offer(node.right);
    		}
    		resList.add(sum / size);
    	}
    	return resList;
    }
}
