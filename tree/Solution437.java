package tree;

import java.util.LinkedList;
import java.util.Queue;

/* ���⣺
 * ����һ��ÿ����㶼����intֵ�Ķ�������
 * �������ۼӳ�ָ��ֵ��·���ĸ�����
 * ·������Ҫ�Ӹ��ڵ㿪ʼ��Ҷ�ӽڵ㣬�������������ߵģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
 * ���Ľڵ�����1000���ڣ����Ҹ�����ֵ��-1000000��1000000֮�䡣
 * 
 * ���磺
 * ���룺
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
 * �����·����Ϊ8��
 * 1.  5 -> 3
   2.  5 -> 2 -> 1
   3.  -3 -> 11
 * */

public class Solution437 {
	
	/* �����Ҫ��ÿ�����ȥ�ж������߲����ۼ��ܲ��ܴﵽҪ������֣���һ���Ƚ��鷳�Ĺ��̣����ǰ����ֽ���������̣�
	 * 1.��ÿ����㣬�����������治ͬ��֧���ܲ����ۼӳ�ָ����ֵ
	 * 2.��������ȥ��ÿ����������һ�����ж�
	 * Ҫ��¼ÿһ���ڵ㣬����ʹ�ö��������н��ļ�¼�ȽϷ��㡣
	 * ����ÿ���ڵ����·���ۼӺ͵��жϣ��õݹ�ȽϺ��ʣ�
	 * ����Ҫע����ǣ�һ�����������·���Ĺ����У�������ֻҪ�ҵ�һ��·���Ϳ����ˣ�����Ҫ�����ж�����·������������
	 * Ҳ����˵��ÿ����㣬�������㼴ʹ�ҵ��ˣ���Ҫ���ҽ�㣬
	 * һ��·������������·�������һ����㻹���ӽ�㣬�ǻ�Ҫ���¿����ܲ��ܼ����ۼ����㣬������һ����·����
	 * ��Ϊ�п���������������ֵ��������ˡ�
	 * �����ڵݹ�Ĺ����У��������ص�ֵ��Ӧ�����ܲ��ܵĲ���ֵ������һ�������ۼӵ����֣�������ִ����һ������������ҵ���·��������
	 * */
	
    public int pathSum(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int res = 0;
        if (root == null) {
        	return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
            	res += canSum(queue.peek(), sum, 0);
                if (queue.peek().left != null) {
                	queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                	queue.offer(queue.peek().right);
                }
                queue.poll();
            }
        }
        return res;
    }
    
    // �������ܴ���������������
    public int canSum(TreeNode root, int tgtSum, int tmpSum) {
        int sumNumber = 0;
        if (root == null) {
        	return sumNumber;
        }
        if (root.val + tmpSum == tgtSum) {
        	sumNumber++;
        }
        sumNumber += canSum(root.left, tgtSum, root.val + tmpSum) + canSum(root.right, tgtSum, root.val + tmpSum);
        return sumNumber;
    }
}
