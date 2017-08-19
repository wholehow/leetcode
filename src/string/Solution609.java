package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Ѱ��ϵͳ���ظ����ļ�
 * ����Ŀ¼��Ϣ�б�����Ŀ¼·�����Լ�������Ŀ¼���������ݵ������ļ�������Ҫ����·���ҵ��ļ�ϵͳ�е������ظ��ļ��顣
 * ���磺
 * ���룺["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * �����[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * */

public class Solution609 {
	
	/* ��Ҫ����������ݸ�ʽ�Ƚ��Ѵ���Ҫ�Կո�ֿ�����i=1��λ�ÿ�ʼ���㡣
	 * �ļ��������ǿ�����Ϊ��root/x + / + x.txt��ɣ����������Ҫ��()�е������ó��������һ�Ҫȥ���ⲿ�ֵ����ݡ�
	 * Ϊ�˵õ����õ�ӳ�䣬��Ҫʹ��Map�ݴ����ݣ�·���� + filename���ļ������֣���
	 * �����ļ������֣���Ϊ���ܳ����ظ��������ҪSetȥ���ظ��Ĳ��֡�
	 * �������"root/a 1.txt(abcd) 2.txt(efgh)"������ʹ�ÿո�ֿ��õ�"root/a" "1.txt(abcd)" "2.txt(efgh)"��
	 * 0��λ�������ǲ���Ҫ�ܵģ���Ϊ���Ǵ�ҹ��еĲ��֣��������Ѱ������ļ������ظ�������·���ظ���
	 * Ȼ����1��2λ�ã���subString�����õ�1.txt��2.txt�����������ظ������Դ浽set�С�
	 * Ȼ�����paths��������벿��ʹ����ͬ�Ĳ�����������������Map��keySet���֡�
	 * */
	
    public List<List<String>> findDuplicate(String[] paths) {
    	List<List<String>> resList = new ArrayList<>();
    	if (paths == null || paths.length == 0) {
    		return resList;
    	}
    	// ��content��filename�ֱ���Ϊkey��value��ͬʱvalueʹ�ü��ϴ洢�����Ա����ظ�
    	Map<String, Set<String>> map = new HashMap<>();
    	for (String path : paths) {
    		// ƥ�����пո��ַ�
    		String[] strs = path.split("\\s+");
    		// ��1��ʼƥ�䣬0��Ϊroot/x
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
