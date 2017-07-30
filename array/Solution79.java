package array;

/* ���⣺
 * ����һ��2D���һ�����ʣ��ҳ���������Ƿ�����������С�
 * �õ��ʿ�����˳�����ڵ�Ԫ����ĸ���ɣ����С����ڡ���Ԫ��ˮƽ��ֱ���ڵĵ�Ԫ����ͬ����ĸ��Ԫ���ܲ��ᱻ���ʹ�á�
 * ���磺
 * ����board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
 * word = "ABCCED", -> returns true,
   word = "SEE", -> returns true,
   word = "ABCB", -> returns false.
 * */

public class Solution79 {
	
	/* �о������Ŀֻ��һ����λ��ȥ�ԣ�û�кõķ�������Ϊ�����ĵ��ʵ�һ����ĸ���ܳ���������һ��λ�ã����ڶ�����ĸ������ֱ�����ڵ�
	 * �����ĸ���ĸ�е�����һ����
	 * ʹ��DFS��˼�룬ֻҪ�ҵ���һ����ĸ���͸����������ڵ��ĸ���ĸȥѰ�ҵڶ�����ĸ�����ڵ�һ����ĸ���ֵ�λ�ÿ����ж���������һ��
	 * ��ʱ�临�ӶȾ���O(N^2),Ѱ�ҵڶ�����ĸ��ʱ����O(N^2)���ܵ���˵����O(N^4)��
	 * */
	
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() < 0) {
        	return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (isContained(board, i, j, chs, 0)) {
        			return true;
        		}
        	}
        }
        return false;
    }
    private boolean isContained(char[][] board, int i, int j, char[] chs, int idx) {
    	// idx��wordÿ����ĸ��λ�ã�idx�͵��ʳ�����ȣ�֤�����ʿ϶����Ѿ��ҵ���
    	if (idx == chs.length) {
    		return true;
    	}
    	if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
    		return false;
    	}
    	if (board[i][j] != chs[idx]) {
    		return false;
    	}
    	// ����ѧ����һ�����ɡ���������ȥ�ظ�ȡ���������Ƕ���char�������256����Ϊchar���뷶Χ0-255��
    	// ����һ�ν������һ������0-255��Χ�ڵ�ֵ��
    	board[i][j] ^= 256;
    	boolean isExisted = isContained(board, i, j + 1, chs, idx + 1) 
    			|| isContained(board, i, j - 1, chs, idx + 1) 
    			|| isContained(board, i + 1, j, chs, idx + 1)
    			|| isContained(board, i - 1, j, chs, idx + 1);
    	// �ڶ������256��������ԭ�����ڶ���ʹ�á���Ϊ��ĸ�ǿ����ظ����ֵ�
    	board[i][j] ^= 256;
    	return isExisted;
    }
}
