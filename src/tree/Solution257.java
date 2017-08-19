package tree;

import java.util.List;
import java.util.ArrayList;

/* ���⣺
 * ����һ�ö��������������и���Ҷ�ӵ�·����
 * 
 * ���磺
 * ���룺
 * 1
  /   \
 2     3
  \
   5
 * �����["1->2->5", "1->3"]
 * */
public class Solution257 {
	
	/* �õݹ飬�����ж���û������Ҷ�ӽڵ㣬�ֱ�ȥ���ݹ飬�ڵݹ��а������Ľڵ�ֵƴ�ӵ�·���ַ��������ע��Ҫƴ�ӡ�->��������ݡ�
	 * ֱ��û�������ӽڵ�󣬱�ʾ�Ѿ�����Ҷ�ӽڵ��ˣ��Ϳ�����ֹ�ˣ�������·�����ַ�����ӵ������ȥ��
	 * */
    private List<String> resList = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
        	findPaths(root, String.valueOf(root.val));
        }
        return resList;
    }
    
    private void findPaths(TreeNode node, String path){
        if (node.left == null && node.right == null) {
        	resList.add(path);
        }
        if (node.left != null) {
        	findPaths(node.left, path + "->" + node.left.val);
        }
        if (node.right != null) {
        	findPaths(node.right, path + "->" + node.right.val);
        }
    }
}
