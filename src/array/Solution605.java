package array;

/* ���⣺
 * ��������flowerbed��ʾһ��������0��ʾλ��Ϊ�գ�1��ʾλ�÷ǿա�
 * ������������ֲ�������ܳ������ڵ�1��
 * ������Ҫ��ֲ�Ļ�����Ŀn���ж��Ƿ��������Ҫ��
 * */

public class Solution605 {
	
	/* �����3���������㣬000���ܷż��軨�أ�
	 * ��ʵ��Ҫȡ��Լ���ҵ�λ�õģ������10001����ôֻ�ܷ�1�裻��������Ǳ߽�Ļ�����ô���ܷ�����101��
	 * �������������ͨ����������0�ĸ�����Ȼ��ֱ������ܷŻ��ĸ������ͱ���Ҫ�Ա߽���д���
	 * ��ô����ʹ������˼·��һ�δ�����������λ�á�
	 * ��pre��next���⴦��߽硣
	 * */
	
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        if (n <= 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            }
            if (flowerbed[i] == 0) {
                int pre = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                if (pre + next == 0) {
                    flowerbed[i] = 1;
                    --n;
                }
            }
        }
        return n <= 0;
    }
}
