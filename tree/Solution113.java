package tree;

import java.awt.List;
import java.util.ArrayList;

/* ����һ�ö�������һ���ͣ��ҵ����и���Ҷ��·��������ÿ��·���ĺ͵��ڸ����ĺ͡�
 * ���磺
 * ���룺
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 * �����[
   		[5,4,11,2],
   		[5,8,4,5]
		]
 * */

public class Solution113 {
	
	/* ͬpathSum I��pathSum II����������һ������������һ�����ɾ���ÿ��DFS��ʱ�����Ǽ���sum-root.val��ֵ��
	 * ��subList��¼��ǰ������·�������root.val=sum��root��һ��Ҷ�ӽ�㣬˵����ǰ·�������������ġ�
	 * */
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> resList = new ArrayList<>();
    	List<Integer> subList = new ArrayList<>();
    	// ����sum<0��Ȼ������Ϊ���Ϸ�������������
    	if (root == null) {
    		return resList;
    	}
    	pathSum(root, sum, resList, subList);
    	return resList;
    }
    private void pathSum(TreeNode root, int sum, List<List<Integer>> resList, List<Integer> subList){
    	if (root == null) {
    		return;
    	}
    	subList.add(new Integer(root.val));
    	if (root.left == null && root.right == null && sum == root.val) {
    		resList.add(new ArrayList<>(subList));
    		// ΪʲôҪɾ�����һ���������n�����������������ǿ��Զ϶���ǰ���n-1���������������ġ�
    		// ��ʱ����ֻ��Ҫ�ҵ�һ���µ�n���ɡ�
    		subList.remove(subList.size() - 1);
    		return;
    	} else {
    		pathSum(root.left, sum - root.val, resList, subList);
    		pathSum(root.right, sum - root.val, resList, subList);
    	}
    	subList.remove(subList.size() - 1);
    }
}
