package array;

/* ����һ��2ά�壬�������а��������Ҳ�ͬ��ս����ս�����ַ�'X'��ʾ���հײ�λ��'.'��ʾ����Ӧ�ü������¹���
 * 1.�����İ�������Ч�ģ�ֻ����ս���Ϳհײ�λ��
 * 2.ս��ֻ��ˮƽ������ֱ���á�
 * 3.ս���ĳߴ���ܲ�ͬ��
 * 4.����ս��֮����ˮƽ���������ֱ�������ٰ���һ���ռ䡪����������ڵ�ս����
 * ����㷨��Ӧ���޸�board��ֵ��
 * */

public class Solution419 {
	
	/* ɨ�跨�����赱ǰλ��ΪX�����������ߺ� �ϱ��Ƿ�ΪX�����������cnt++
	 * ֻ�������Ͽ���ʡһ���ʱ�䡣
	 * */
	
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
        	return 0;
        }
        int count = 0, row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') 
        				&& (j == 0 || board[i][j - 1] == '.')) {
        			count++;
        		}
        	}
        }
        return count;
    }
}
