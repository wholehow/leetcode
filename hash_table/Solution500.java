package hash_table;

import java.awt.List;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 大意：
 * 键盘行。
 * 给出一个单词列表，返回可以使用一行字母键入的单词，规定键盘为美式键盘。
 * 例如：
 * 输入：["Hello", "Alaska", "Dad", "Peace"]
 * 输出：["Alaska", "Dad"]
 * 注意：
 * 1.你可以多次使用键盘中的一个字符。
 * 2.你可以假定输入字符串只包含字母表。
 * */

public class Solution500 {
	
	/* 首先需要存储美式键盘每一行的字符序列。对于每一个序列存入HashMap，key=char，value=对于当前序列来说它的索引。
	 * 对于每一个给定的单词，从左到右扫描，判读第一个与其后的所有letter是否在同一行。最后的结果用ArrayList保存，在转换为String数组。
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
        	char[] letters = word.toLowerCase().toCharArray();	//这里必须要忽略大小写
        	boolean sameRow = true;
        	int rowIndex = map.get(letters[0]);	//用第一个字母作为基准与之后的字母进行比较判断是否在同一行
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
