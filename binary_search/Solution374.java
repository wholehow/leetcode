package binary_search;

/* ���⣺
 * ���������������Ϸ����Ϸ�������£�
 * ����ѡһ��1��n֮������֡���������ѡ�����ĸ����֡�
 * ÿһ����´��Ҷ�����������ָ��˻��ǵ��ˡ�
 * ����Ե���һ��Ԥ�����API guess(int num)������3�ֽ�� (-1, 1, �� 0)��
 * -1 : �ҵ����ָ���
 	1 : �ҵ����ָ���
 	0 : ��ϲ�㣡�¶��ˣ�
 * */

/* The guess API is defined in the parent class GuessGame.
	@param num, your guess
	@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   		int guess(int num); */

public class Solution374 {
	
	/* �������һ�����͵Ĳ¼۸�����⣬���ݶԷ�˵���˻��ǵ�������С��Χ����򵥿��ٵķ��������۰���������ԭ��ܼ򵥡�
	 * */
	
    public int guessNumber(int n) {
        if (guess(n) == 0) {
        	return n;
        }
        int left = 1, right = n;
        while (left < right) {
        	int mid = left + (right - left) / 2;
        	int tmp = guess(mid);
        	if (tmp == 0) {
        		return mid;
        	} else if (tmp == 1) {
        		left = mid;
			} else {
				right = mid;
			}
        }
        return left;
    }	
}
