package tree;

import java.util.ArrayList;
import java.util.List;

/* ����ͬ96��������Ҫ��������BST�Ľṹ��
 * */

public class Solution95 {
	
	/* ����ע�⵽1..n�ǽڵ�1��n���κ�BST�İ�˳������� �������ѡ���i���ڵ���Ϊ����������������Ԫ��1����i-1����
	 * ������������Ԫ�أ�i + 1����n�� ʹ�õݹ��������ȡ�������������п��ܵ������������п��ܵķ�ʽ����������������
	 * �о��ⲻ��DP���⣬��Ӧ���Ƿ��Ρ�
	 * */
	
	public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
	    return genTreeList(1,n);
	}

	private List<TreeNode> genTreeList(int start, int end) {
	    List<TreeNode> list = new ArrayList<TreeNode>(); 
	    if (start > end) {
	        list.add(null);
	    }
	    for (int idx = start; idx <= end; idx++) {
	        List<TreeNode> leftList = genTreeList(start, idx - 1);
	        List<TreeNode> rightList = genTreeList(idx + 1, end);
	        for (TreeNode left : leftList) {
	            for(TreeNode right: rightList) {
	                TreeNode root = new TreeNode(idx);
	                root.left = left;
	                root.right = right;
	                list.add(root);
	            }
	        }
	    }
	    return list;
	}
}
