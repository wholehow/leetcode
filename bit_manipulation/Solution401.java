package bit_manipulation;

import java.util.ArrayList;

/* 大意：
 * 一个二进制手表顶端有4盏LED灯表示小时(0-11)，底部有6盏LED灯表示分钟(0-59)。
 * 每一盏LED灯表示一个0或1，最右端为最低位。
 * 给定一个非负整数n表示当前燃亮的LED灯数，返回所有可能表示的时间。
 * 注意：
 * 1.输出顺序不重要。
 * 2.小时不可以包含前缀0，例如"01:00"是无效的，应当为"1:00"。
 * 3.分钟必须包含两位数字，可以包含前导0，例如"10:2"是无效的，应当为"10:02"。
 * */

public class Solution401 {
	
	/* 轮询遍历法 */
	
	/*public List<String> readBinaryWatch(int num) {
	    List<String> times = new ArrayList<>();
	    for (int h = 0; h < 12; h++)
	        for (int m = 0; m < 60; m++)
	            if (Integer.bitCount(h * 64 + m) == num)
	                times.add(String.format("%d:%02d", h, m));
	    return times;
	}*/
	
	/* 位运算法
	 * 10盏灯泡的燃亮情况可以通过0-1024进行表示，然后计数二进制1的个数即可。
	 * 利用位运算将状态拆分为小时和分钟。
	 * */
	
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> ans = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> hour = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> min = new ArrayList<ArrayList<Integer>>();
        // 小时灯
        for (int i = 0; i < 4; i++) {
        	hour.add(new ArrayList<Integer>());
        }
        // 分钟灯
        for (int i = 0; i < 6; i++) {
        	min.add(new ArrayList<Integer>());
        }
        // 小时制
        for (int i = 0; i < 12; i++) {
        	// java.lang.Integer.bitCount() 返回指定int值的二进制补码表示形式的1位的数量。这有时被称为作为总体计数
            int n = Integer.bitCount(i);
            hour.get(n).add(i);
        }
        // 分钟制
        for (int i = 0; i < 60; i++) {
            min.add(new ArrayList<Integer>());
            int n = Integer.bitCount(i);
            min.get(n).add(i);
        }
        for (int i = 0; i <= num && i < 4; i++) {
            for (int h = 0; h < hour.get(i).size(); h++) {
                for (int m = 0; m < min.get(num - i).size() && num - i < 6; m++) {
                    String string = hour.get(i).get(h).toString() + ":";	// 第i个的hour
                    if (min.get(num - i).get(m) < 10) {
                        string += "0";
                    }
                    string += min.get(num - i).get(m).toString();	//第i个的min
                    ans.add(string);
                }
            }
        }
        return ans;
    }
}
