package array;

/* 大意：
 * 给定一个2D板和一个单词，找出这个单词是否存在于网格中。
 * 该单词可以由顺序相邻单元的字母构成，其中“相邻”单元是水平或垂直相邻的单元。相同的字母单元可能不会被多次使用。
 * 例如：
 * 给定board =
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
	
	/* 感觉这个题目只能一个个位置去试，没有好的方法，因为给出的单词第一个字母可能出现在任意一个位置，而第二个字母可以是直接相邻的
	 * 其他四个字母中的任意一个。
	 * 使用DFS的思想，只要找到第一个字母，就根据与它相邻的四个字母去寻找第二个字母。由于第一个字母出现的位置可能有多个，因此这一步
	 * 的时间复杂度就是O(N^2),寻找第二个字母的时候还是O(N^2)，总的来说就是O(N^4)。
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
    	// idx是word每个字母的位置，idx和单词长度相等，证明单词肯定是已经找到了
    	if (idx == chs.length) {
    		return true;
    	}
    	if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
    		return false;
    	}
    	if (board[i][j] != chs[idx]) {
    		return false;
    	}
    	// 这里学到了一个技巧。类似整数去重复取反，这里是对于char类型异或256，因为char编码范围0-255。
    	// 异或第一次将它变成一个不在0-255范围内的值。
    	board[i][j] ^= 256;
    	boolean isExisted = isContained(board, i, j + 1, chs, idx + 1) 
    			|| isContained(board, i, j - 1, chs, idx + 1) 
    			|| isContained(board, i + 1, j, chs, idx + 1)
    			|| isContained(board, i - 1, j, chs, idx + 1);
    	// 第二次异或256，将它还原，供第二次使用。因为字母是可以重复出现的
    	board[i][j] ^= 256;
    	return isExisted;
    }
}
