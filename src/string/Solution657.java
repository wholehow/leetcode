package string;

/* 初始位于坐标(0, 0)，UDLR分别表示向上下左右移动，求移动结束后是否位于原点。
 * */

public class Solution657 {
    public boolean judgeCircle(String moves) {
        // x横坐标，y纵坐标
    	int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') x++;
            else if (c == 'L') x--;
            else if (c == 'U') y--;
            else if (c == 'D') y++;
        }
        return x == 0 && y == 0;
    }
}
