package math;

import java.util.HashMap;

/* ����������ת��Ϊ������
 * ������Χ�޶���1-3999��
 * */

public class Solution13 {
	
	/* �ٶȵģ��������ּ�������
	 * 	�����ַ�		I	V	X	L	C	D	M
	 * ��Ӧ����������	1	5	10	50	100	500	1000
	 * 1.��ͬ��������д������ʾ����������Щ������ӵõ����������磺III = 3
	 * 2.С�������ڴ�������ұߣ�����ʾ����������Щ������ӵõ����������磺VIII = 8
	 * 3.С�����֣����ڣ�I��X��C���ڴ��������ߣ�����ʾ�������ڴ�����ȥС�����õ��������磺IV = 4
	 * 4.����ʹ��ʱ�������������ظ����ó�������
	 * 5.��һ���������滭���ߣ���ʾ���������1000��������ֻ����3999���ڵ����������ò�����������
	 * 
	 * ��Ȼ�������ֵ���д�����Ϊ���ӣ��������������֡�����Ҽ����Ĺ��ɣ����Թ�������򵥵���������ת�����������ֵķ�����
	 * ���������󣨴ӵ�λ���λ�������������֣���������һ�����ִ�����־ͼ��ϣ���������һ������С�����־ͼ�ȥ��
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
        int temp = 0; //��ʱ�����������жϼӼ�
        int weight = 0; //��ǰ��ȡ�����������ֵ�Ȩ��
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
