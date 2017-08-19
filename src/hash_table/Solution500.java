package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* ���⣺
 * �����С�
 * ����һ�������б����ؿ���ʹ��һ����ĸ����ĵ��ʣ��涨����Ϊ��ʽ���̡�
 * ���磺
 * ���룺["Hello", "Alaska", "Dad", "Peace"]
 * �����["Alaska", "Dad"]
 * ע�⣺
 * 1.����Զ��ʹ�ü����е�һ���ַ���
 * 2.����Լٶ������ַ���ֻ������ĸ��
 * */

public class Solution500 {
	
	/* ������Ҫ�洢��ʽ����ÿһ�е��ַ����С�����ÿһ�����д���HashMap��key=char��value=���ڵ�ǰ������˵����������
	 * ����ÿһ�������ĵ��ʣ�������ɨ�裬�ж���һ������������letter�Ƿ���ͬһ�С����Ľ����ArrayList���棬��ת��ΪString���顣
	 * */
	
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
        	for (char letter : rows[i].toCharArray()) {
        		map.put(letter, i);
        	}
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
        	char[] letters = word.toLowerCase().toCharArray();
        	boolean sameRow = true;
        	int rowIndex = map.get(letters[0]);
        	for (char letter : letters) {
        		if (rowIndex != map.get(letter)) {
        			sameRow = false;
        			break;
        		}
        	}
        	if (sameRow) {
        		list.add(word);
        	}
        }
        String[] rst = new String[list.size()];
        int index = 0;
        for (String string : list) {
        	rst[index++] = string;
        }
        return rst;
    }
}
