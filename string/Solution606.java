package string;

import java.util.Stack;

import javax.swing.tree.TreeNode;

/* ���⣺
 * �����ַ����ع���������
 * ����������ֺ����ţ����ִ�����ڵ㣬�����ڵ��Ӵ��������Һ��ӡ�
 * ע�⣺
 * �����ַ���ֻ����'(', ')��'-'������'0'-'9'��
 * 
 * ���磺
 * ���룺Binary tree: [1,2,3,4] 
 * 	   1
     /   \
    2     3
   /    
  4     
 * �����"1(2(4))(3)"
 * 
 * ���룺Binary tree: [1,2,3,null,4]
 *     1
     /   \
    2     3
     \  
      4 
 * ����� "1(2()(4))(3)"
 * */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution606 {
	
	/* �����������������ַ����ıȶԣ�����ֱ��ʹ�ö���������������Ϳɡ�
	 * ע����ջ˳�򼴿ɡ�
	 * */
	
	public static String tree2str(TreeNode t) {
    	StringBuilder sBuilder = new StringBuilder(); 
    	if (t == null) {
    		return "";	//leetcode�ö�������������÷���null
    	}
    	Stack<Object> stack = new Stack<Object>();
    	//���ڵ���ջ
    	stack.push(t);
    	while (!stack.empty()) {
    		//ջ�а���TreeNode���͵Ķ������ڵ㣬Ҳ����String���͵�����
    		Object temp = stack.pop();
    		//�ж��Ƿ�ΪTreeNode����
    		if (temp instanceof TreeNode) {
    			TreeNode node = (TreeNode) temp;
    			sBuilder.append(node.val);
    			//����ýڵ����ҽڵ㶼Ϊ�գ���ִ���κδ��룬����ִ�����´���
    			if (node.left != null || node.right != null) {
    				if (node.right != null) {
            			stack.push(")");
            			stack.push(node.right);
            			stack.push("(");
            		}
            		if(node.left != null) {
            			stack.push(")");
            			stack.push(node.left);
            			stack.push("(");
            		} else {
            			stack.push(")");
            			stack.push("(");
            		}
    			}
    		}
    		//�ж��Ƿ�ΪString����
    		if (temp instanceof String) {
    			//String����ֱ��ƴ�ӵ�builder
    			sBuilder.append((String) temp);
    		}
       	}
    	return sBuilder.toString();
    }
}
