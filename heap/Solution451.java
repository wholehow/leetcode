package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/* �����ַ����ֵ�Ƶ�ʶ��ַ�����������
 * */

public class Solution451 {
	
	// Map+Ͱ����
    /*public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
        	map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // ����Ͱ����
        List<Character>[] bucket = new List[chs.length + 1];
        int freq = 0;
        for (char key : map.keySet()) {
        	freq = map.get(key);
        	if (bucket[freq] == null) {
        		bucket[freq] = new ArrayList<>();
        	}
        	bucket[freq].add(key);
        }
        // ȡ��Ͱ�е�����
        StringBuilder sBuilder = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
        	if (bucket[pos] != null) {
        		for (char ch : bucket[pos]) {
        			for (int i = 0; i < map.get(ch); i++) {
        				sBuilder.append(ch);
        			}
        		}
        	}
        }
        return sBuilder.toString();
    }*/
    
    // ������
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
        	map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                    return -a.getValue() + b.getValue();
                }
            }
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
