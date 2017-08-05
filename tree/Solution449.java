package tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.xml.crypto.Data;

/* ���л��뷴���л�������
 * */

public class Solution449 {
	
	/* ���ֱ�����ʽ������ʵ�����л��ͷ����л���
	 * ����������Ҫ��һ��������л���֮�󣬷����л�����û�ԭ��ȥ�����������Ҫ������Ҷ�ӽ���null��㡣
	 * */
	
	// ����ݹ�ʵ�����л�
    public String serialize(TreeNode root) {
        if (root == null) {
        	return "#!";
        }
        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // reconPreOrder�����ݹ鴦����������
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
