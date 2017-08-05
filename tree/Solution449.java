package tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.xml.crypto.Data;

/* 序列化与反序列化二叉树
 * */

public class Solution449 {
	
	/* 四种遍历方式都可以实现序列化和反序列化。
	 * 过程中最重要的一点就是序列化完之后，反序列化必须得还原回去。因此我们需要特殊标记叶子结点和null结点。
	 * */
	
	// 先序递归实现序列化
    public String serialize(TreeNode root) {
        if (root == null) {
        	return "#!";
        }
        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // reconPreOrder方法递归处理左右子树
    public TreeNode deserialize(String data) {
        String[] strs = data.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (String str : strs) {
        	queue.offer(str);
        }
        return reconPreOrder(queue);
    }
    private TreeNode reconPreOrder(Queue<String> queue) {
    	String val = queue.poll();
    	if (val.equals("#")) {
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(val));
    	root.left = reconPreOrder(queue);
    	root.right = reconPreOrder(queue);
    	return root;
    }
}
