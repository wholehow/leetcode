package hash_table;

import java.util.HashSet;

/* ���⣺
 * ����һ������ż�����ȵ��������飬�������еĲ�ͬ���ֱ�ʾ��ͬ������ǹ���ÿ�����ֱ�ʾ��Ӧ���͵�һ���ǹ���
 * ����Ҫ����Щ�ǹ�������������͸�硣���ؽ����Ի�õ����������ǹ���
 * ���磺
 * ���룺candies = [1,1,2,2,3,3]
 * �����3�������ֲ�ͬ������ǹ���1,2��3����ÿ���ǹ������� ��ѷ��䣺������ǹ�[1,2,3]�����Ҳ���ǹ�[1,2,3]�� ��������ֲ�ͬ���ǹ���
 * ���룺candies = [1,1,2,3]��
 * �����2��������ǹ�[2,3]���ֵ����ǹ�[1,1]�� ��������ֲ�ͬ���ǹ������ֻ��һ���ǹ���
 * */

public class Solution575 {
	
	/* ʹ��HashSet���������Ҫ������������ǹ���Ҳ����Ҫset�Ĵ�С����Ӧ���ǵ�ǰ���鳤�ȵ�һ�롣
	 * ��Ŀ�������鳤�Ȼ���ż������ͺܺô����ˡ����ǽ������е�Ԫ�طֱ���ӽ�set������set��size���ܴ������鳤�ȵ�һ�룬
	 * �������һ�룬����һ�룻���򷵻�����size��
	 * */
	
    public int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
        	return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
        	set.add(candy);
        }
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }
}
