package hash_table;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/* 给定一个非空整数数组，返回出现频率最高的K个元素。
 * */

public class Solution347 {
	
	// 这道题目出的非常好，虽然思路很基础，但是很考察对于Java各种容器的认识和使用
	
	/* 1.用HashMap记录每个数和其出现的频率，利用Heap实现取top K个元素。
	 * */
	
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> resList = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0 || k < 1) return resList;
    	// 将nums中的数按照出现和对应频次添加进map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 使用PriorityQueue建立大根堆
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
    
    // 2.利用HashMap和桶排序
	
	/*public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> resList = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0 || k < 1) return resList;
    	// 将nums中的数按照出现和对应频次添加进map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 使用桶排序
        List<Integer>[] bucket = new List[nums.length+1];
        for (int num : map.keySet()) {
        	int freq = map.get(num);
        	// 桶排序核心
        	if (bucket[num] == null) {
        		bucket[freq] = new LinkedList<Integer>();
        	}
        	bucket[freq].add(num);
        }
        for (int i = bucket.length() - 1; i > 0 && k > 0; i--) {
        	// 桶排序核心
        	if (bucket[i] != null) {
        		List<Integer> list = bucket[i]; 
        		resList.addAll(list);
        		k -= list.size();
        	}
        }
        return resList;
	}*/
	
	// 3.使用Java的TreeMap，一种内部有序的Map
	
	/*public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> resList = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0 || k < 1) return resList;
    	// 将nums中的数按照出现和对应频次添加进map
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
