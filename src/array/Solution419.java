package array;

/* 给定一个2维板，计算其中包含多少艘不同的战舰。战舰用字符'X'表示，空白槽位用'.'表示。你应该假设如下规则：
 * 1.给定的板子是有效的，只包含战舰和空白槽位。
 * 2.战舰只能水平或者竖直放置。
 * 3.战舰的尺寸可能不同。
 * 4.两艘战舰之间在水平方向或者竖直方向至少包含一个空间—不会存在相邻的战舰。
 * 你的算法不应该修改board的值。
 * */

public class Solution419 {
	
	/* 扫描法。假设当前位置为X，检查它的左边和 上边是否为X。如果不是则cnt++
	 * 只检查左和上可以省一半的时间。
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
