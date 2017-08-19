package tree;

/* ��BST��ɾ����㡣
 * ʱ�临�Ӷ�ӦΪO�����ĸ߶ȣ�
 * */

public class Solution450 {
	
	/* ɾ����㲻�ѣ��ѵ�����ɾ�����֮����뱣֤��ʣ�µĽ�����»�ԭΪһ��BST��
	 * */
	
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.left == null && root.right == null)) {
        	return null;
        }
        
        if (root.val > key) {
        	root.left = deleteNode(root.left, key);	// �ݹ�������
        } else if (root.val < key) {
        	root.right = deleteNode(root.right, key);	// �ݹ�������
        } else {
        	if (root.left == null) {
        		return root.right;	// ֻʣһ���ҽ��
        	} else if (root.right == null){
        		return root.left; 	// // ֻʣһ�������
        	}
        	// ����ɾ�����������ڵ�ǰ����������ָ��任����ֻ��Ҫ�仯�����½���ָ��
        	TreeNode minNode = finMin(root.right);
        	root.val = minNode.val;	// ����������Сֵ�뵱ǰ��㽻�����Ժ�ɾ����ֵ������С�Ľ��
        	root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    // BST�������½��һ����ֵ��С�Ľ��
    private TreeNode finMin(TreeNode root) {
    	while (root.left != null) {
    		root = root.left;
    	}
    	return root;
    }
}	
