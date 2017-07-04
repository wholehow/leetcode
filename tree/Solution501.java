package tree;

/* ��BST��������
 * */

public class Solution501 {
	
	/* ���ﶨ���BST
	 * left <= mid <= right
	 * ���Բ����ϸ�Ĳ��ȹ�ϵ��ע��������Ŀ��
	 * ��Ȼû�е��ڴ��������Ŀ�ǲ����ܳ����ĵ���Ϊ�������������ڹ�����
	 * ��ĿҪ��O(1)�Ŀռ临�Ӷȣ�����������Ҫ�ȵõ��ж��ٸ�modes��������ռ䡣
	 * ��������stack space������ռ临�Ӷȣ���˿��õݹ顣
	 * */
	
	private int cntModes = 0;	//modes������
	private int curValue = 0;	//��ѡmodes��ֵ
	private int curCount = 0;	//��ѡmodes������
	private int[] modes;
	private int maxCount;		//�����ж��Ƿ���Գ�Ϊ������modes
	
    public int[] findMode(TreeNode root) {
        countModes(root);	//��ĿҪ��O(1)�Ŀռ临�Ӷȣ�����������Ҫ�ȵõ��ж��ٸ�modes��������ռ䡣
        modes = new int[cntModes];
        curCount = 0;
        cntModes = 0;
        countModes(root);
        return modes;
    }
    private void countModes(TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	countModes(node.left);
    	if (node.val != curValue) {
    		curCount = 1;
    		curValue = node.val;
    	} else {
    		curCount++;
    	}
    	if (curCount > maxCount) {
    		maxCount = curCount;
    		curCount = 1;
    	} else if (curCount == maxCount) {
    		if (modes != null) {
    			modes[cntModes] = node.val;
    		}
    		cntModes++;
    	}
    	countModes(node.right);
    }
}
