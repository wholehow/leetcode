package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* 寻找系统中重复的文件
 * 给出目录信息列表（包括目录路径）以及包含此目录中所有内容的所有文件，你需要根据路径找到文件系统中的所有重复文件组。
 * 例如：
 * 输入：["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * 输出：[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * */

public class Solution609 {
	
	/* 主要是输入的数据格式比较难处理，要以空格分开，从i=1的位置开始计算。
	 * 文件名字我们可以人为是root/x + / + x.txt组成，因此我们需要把()中的内容拿出来，并且还要去掉这部分的内容。
	 * 为了得到良好的映射，需要使用Map暂存内容（路径） + filename（文件的名字）。
	 * 对于文件的名字，因为可能出现重复，因此需要Set去掉重复的部分。
	 * 例如对于"root/a 1.txt(abcd) 2.txt(efgh)"，首先使用空格分开得到"root/a" "1.txt(abcd)" "2.txt(efgh)"。
	 * 0的位置我们是不需要管的，因为那是大家共有的部分，并且最后寻求的是文件内容重复而不是路径重复。
	 * 然后处理1和2位置，用subString方法得到1.txt和2.txt。这两个不重复都可以存到set中。
	 * 然后对与paths后面的输入部分使用相同的操作。最后的输出结果是Map的keySet部分。
	 * */
	
    public List<List<String>> findDuplicate(String[] paths) {
    	List<List<String>> resList = new ArrayList<>();
    	if (paths == null || paths.length == 0) {
    		return resList;
    	}
    	// 将content和filename分别作为key和value，同时value使用集合存储，可以避免重复
    	Map<String, Set<String>> map = new HashMap<>();
    	for (String path : paths) {
    		// 匹配所有空格字符
    		String[] strs = path.split("\\s+");
    		// 从1开始匹配，0作为root/x
    		for (int i = 1; i < strs.length; i++) {
    			int idx = strs[i].indexOf("(");
    			String content = strs[i].substring(idx);
    			String filename = strs[0] + "/" + strs[i].substring(0, idx);
    			Set<String> filenames = map.getOrDefault(content, new HashSet<String>());
    			filenames.add(filename);
    			map.put(content, filenames);
    		}
    	}
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
            	resList.add(new ArrayList<String>(map.get(key)));
            }
        }
        return resList;
    }
}
