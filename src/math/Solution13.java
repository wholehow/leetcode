package math;

import java.util.HashMap;

/* 将罗马数字转换为整数。
 * 整数范围限定在1-3999。
 * */

public class Solution13 {
	
	/* 百度的，罗马数字计数规则：
	 * 	基本字符		I	V	X	L	C	D	M
	 * 对应阿拉伯数字	1	5	10	50	100	500	1000
	 * 1.相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
	 * 2.小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
	 * 3.小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
	 * 4.正常使用时，连续的数字重复不得超过三次
	 * 5.在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）
	 * 
	 * 虽然罗马数字的书写规则较为复杂，但根据罗马数字“左加右减”的规律，可以构造出更简单的罗马数字转换阿拉伯数字的方法：
	 * 即从右向左（从低位向高位）考察罗马数字，遇到比上一个数字大的数字就加上，遇到比上一个数字小的数字就减去。
	 * */
	
    public int romanToInt(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        
        int result = 0; 
        int temp = 0; //临时变量，用于判断加减
        int weight = 0; //当前读取到的罗马数字的权重
        for (int i = s.length() - 1; i >= 0; i--) {
            weight = hashMap.get(s.charAt(i));
            if (temp <= weight) {
                result += weight;
                temp = weight;
            } else {
                result -= weight;
                temp = weight;
            }
        }        
        return result;
    }
}
