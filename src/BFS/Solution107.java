package BFS;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/* 大意：
 * 给出一个二叉树，返回从下到上的节点值序列。（比如，从左到右，一层层地从叶子到根）。
 * 例如：
 * 输入：         3
   		 / \
  		9  20
    	  /  \
   		 15   7
 * 输出：[
  		[15,7],
  		[9,20],
  		[3]
		]	
 * */

public class Solution107 {
	
	/* 广度优先遍历就是一层层地攻略过去，把每一层的所有节点都记录下来再走向下一层。
	 * 因为每层会有多个节点，不是简单的一个左节点一个右节点的，
	 * 所以这里用到队列，用队列的先进先出特性来记录每一层的节点，保证对每层的每个节点都处理到其子节点，并将值记录下来。
	 * 队列用到Queue这个类，offer方法可以添加一个元素，peek方法获取队首的元素，poll方法会从队首移除一个元素并获取它。
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
            resLists.add(0, subList);	//每次遍历一层节点结束时候，将该层节点组成的list放到整体的list之前，实现由底到高的排列
        }
        return resLists;
    }
	
	/* 深度优先遍历一般用递归来实现，也就是对每个方向都用递归来找到最底层的叶子节点，一层层处理回来，把每层的节点值添加到当前层的List中去。
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
        list.get(list.size() - level - 1).add(root.val);	//每次遍历一层节点结束时候，将该层节点组成的list放到整体的list之前，实现由底到高的排列
    }*/
}
