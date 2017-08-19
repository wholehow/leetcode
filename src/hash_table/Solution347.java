package hash_table;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/* ����һ���ǿ��������飬���س���Ƶ����ߵ�K��Ԫ�ء�
 * */

public class Solution347 {
	
	// �����Ŀ���ķǳ��ã���Ȼ˼·�ܻ��������Ǻܿ������Java������������ʶ��ʹ��
	
	/* 1.��HashMap��¼ÿ����������ֵ�Ƶ�ʣ�����Heapʵ��ȡtop K��Ԫ�ء�
	 * */
	
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> resList = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0 || k < 1) return resList;
    	// ��nums�е������ճ��ֺͶ�ӦƵ����ӽ�map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // ʹ��PriorityQueue���������
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	maxHeap.add(entry);
        }
        while (resList.size() < k) {
        	Map.Entry<Integer, Integer> entry = maxHeap.poll();
        	resList.add(entry.getKey());
        }
        return resList;
    }
    
    // 2.����HashMap��Ͱ����
	
	/*public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> resList = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0 || k < 1) return resList;
    	// ��nums�е������ճ��ֺͶ�ӦƵ����ӽ�map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // ʹ��Ͱ����
        List<Integer>[] bucket = new List[nums.length+1];
        for (int num : map.keySet()) {
        	int freq = map.get(num);
        	// Ͱ�������
        	if (bucket[num] == null) {
        		bucket[freq] = new LinkedList<Integer>();
        	}
        	bucket[freq].add(num);
        }
        for (int i = bucket.length() - 1; i > 0 && k > 0; i--) {
        	// Ͱ�������
        	if (bucket[i] != null) {
        		List<Integer> list = bucket[i]; 
        		resList.addAll(list);
        		k -= list.size();
        	}
        }
        return resList;
	}*/
	
	// 3.ʹ��Java��TreeMap��һ���ڲ������Map
	
	/*public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> resList = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0 || k < 1) return resList;
    	// ��nums�е������ճ��ֺͶ�ӦƵ����ӽ�map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
        	int freq = map.get(num);
        	if (!freqMap.containsKey(num)) {
                freqMap.put(freq, new LinkedList<Integer>());
        	}
        	freqMap.get(freq).add(num);
        }
        while (resList.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            resList.addAll(entry.getValue());
        }
        return resList;
	}*/
}
