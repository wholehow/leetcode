package string;

/* ��ʼλ������(0, 0)��UDLR�ֱ��ʾ�����������ƶ������ƶ��������Ƿ�λ��ԭ�㡣
 * */

public class Solution657 {
    public boolean judgeCircle(String moves) {
        // x�����꣬y������
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
