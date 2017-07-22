package bit_manipulation;

import java.util.ArrayList;

/* ���⣺
 * һ���������ֱ�����4յLED�Ʊ�ʾСʱ(0-11)���ײ���6յLED�Ʊ�ʾ����(0-59)��
 * ÿһյLED�Ʊ�ʾһ��0��1�����Ҷ�Ϊ���λ��
 * ����һ���Ǹ�����n��ʾ��ǰȼ����LED�������������п��ܱ�ʾ��ʱ�䡣
 * ע�⣺
 * 1.���˳����Ҫ��
 * 2.Сʱ�����԰���ǰ׺0������"01:00"����Ч�ģ�Ӧ��Ϊ"1:00"��
 * 3.���ӱ��������λ���֣����԰���ǰ��0������"10:2"����Ч�ģ�Ӧ��Ϊ"10:02"��
 * */

public class Solution401 {
	
	/* ��ѯ������ */
	
	/*public List<String> readBinaryWatch(int num) {
	    List<String> times = new ArrayList<>();
	    for (int h = 0; h < 12; h++)
	        for (int m = 0; m < 60; m++)
	            if (Integer.bitCount(h * 64 + m) == num)
	                times.add(String.format("%d:%02d", h, m));
	    return times;
	}*/
	
	/* λ���㷨
	 * 10յ���ݵ�ȼ���������ͨ��0-1024���б�ʾ��Ȼ�����������1�ĸ������ɡ�
	 * ����λ���㽫״̬���ΪСʱ�ͷ��ӡ�
	 * */
	
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> ans = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> hour = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> min = new ArrayList<ArrayList<Integer>>();
        // Сʱ��
        for (int i = 0; i < 4; i++) {
        	hour.add(new ArrayList<Integer>());
        }
        // ���ӵ�
        for (int i = 0; i < 6; i++) {
        	min.add(new ArrayList<Integer>());
        }
        // Сʱ��
        for (int i = 0; i < 12; i++) {
        	// java.lang.Integer.bitCount() ����ָ��intֵ�Ķ����Ʋ����ʾ��ʽ��1λ������������ʱ����Ϊ��Ϊ�������
            int n = Integer.bitCount(i);
            hour.get(n).add(i);
        }
        // ������
        for (int i = 0; i < 60; i++) {
            min.add(new ArrayList<Integer>());
            int n = Integer.bitCount(i);
            min.get(n).add(i);
        }
        for (int i = 0; i <= num && i < 4; i++) {
            for (int h = 0; h < hour.get(i).size(); h++) {
                for (int m = 0; m < min.get(num - i).size() && num - i < 6; m++) {
                    String string = hour.get(i).get(h).toString() + ":";	// ��i����hour
                    if (min.get(num - i).get(m) < 10) {
                        string += "0";
                    }
                    string += min.get(num - i).get(m).toString();	//��i����min
                    ans.add(string);
                }
            }
        }
        return ans;
    }
}
