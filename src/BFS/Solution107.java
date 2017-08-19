package BFS;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/* ���⣺
 * ����һ�������������ش��µ��ϵĽڵ�ֵ���С������磬�����ң�һ���ش�Ҷ�ӵ�������
 * ���磺
 * ���룺         3
   		 / \
  		9  20
    	  /  \
   		 15   7
 * �����[
  		[15,7],
  		[9,20],
  		[3]
		]	
 * */

public class Solution107 {
	
	/* ������ȱ�������һ���ع��Թ�ȥ����ÿһ������нڵ㶼��¼������������һ�㡣
	 * ��Ϊÿ����ж���ڵ㣬���Ǽ򵥵�һ����ڵ�һ���ҽڵ�ģ�
	 * ���������õ����У��ö��е��Ƚ��ȳ���������¼ÿһ��Ľڵ㣬��֤��ÿ���ÿ���ڵ㶼�������ӽڵ㣬����ֵ��¼������
	 * �����õ�Queue����࣬offer�����������һ��Ԫ�أ�peek������ȡ���׵�Ԫ�أ�poll������Ӷ����Ƴ�һ��Ԫ�ز���ȡ����
	 * */
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> resLists = new LinkedList<List<Integer>>();   
        if(root == null) {
        	return resLists;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                	queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                	queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            resLists.add(0, subList);	//ÿ�α���һ��ڵ����ʱ�򣬽��ò�ڵ���ɵ�list�ŵ������list֮ǰ��ʵ���ɵ׵��ߵ�����
        }
        return resLists;
    }
	
	/* ������ȱ���һ���õݹ���ʵ�֣�Ҳ���Ƕ�ÿ�������õݹ����ҵ���ײ��Ҷ�ӽڵ㣬һ��㴦���������ÿ��Ľڵ�ֵ��ӵ���ǰ���List��ȥ��
	 * */
	
    /*public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resLists = new LinkedList<List<Integer>>();
        levelMaker(resLists, root, 0);
        return resLists;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) {
        	return;
        }
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);	//ÿ�α���һ��ڵ����ʱ�򣬽��ò�ڵ���ɵ�list�ŵ������list֮ǰ��ʵ���ɵ׵��ߵ�����
    }*/
}
