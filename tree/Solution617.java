package tree;

/* ���⣺
 * �������ö������������������һ����������һ����ʱ������������һЩ������ص��ģ�����һЩ������ǡ�
 * ����Ҫ�����Ǻϲ���һ���µĶ�������
 * �ϲ������ǣ������������ص����򽫽��ֵ�ĺ���Ϊ�ϲ�������ֵ�����򣬷ǿսڵ㽫�����������Ľڵ㡣
 * �ϲ�ǰ��
 * 	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7  
 * �ϲ���  3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 * */

public class Solution617 {
	
	/* �����кܶ࣬�ؼ�һ���Ƕ�������������ͬ�ı����������ܱ�֤���Ľ����������Ҫ�ġ�
	 * ����ʹ�õݹ�ķ������ö�����ǰ������ķ������������ֵ����󷵻ظ��ڵ㡣
	 * */
	
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
        	return null;
        }
        if (t1 == null || t2 == null) {
        	return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
