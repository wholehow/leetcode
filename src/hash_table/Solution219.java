package hash_table;

import java.util.HashMap;
import java.util.HashSet;

/* 大意：
 * 给出一个整型数组和一个整型数k，判断数组中是否任何两个不一样的位置i和j，
 * 如果 nums[i] == nums[j] ，i和j的距离不大于k。
 * */

public class Solution219 {
	
	/* 这道题看起来简单，不过有很多陷阱，比如如果k = 0，那么无论数组如何都是错的。
	 * 如果数组中不存在一样的两个数，也是错的。
	 * 如果数组中存在多个一样的同一个数，只要有最短的两个的距离小于等于k就可以了。
	 * */
	
	/* HashMap
	 * */
	
    public boolean containsNearbyDuplicate(int[] nums, int k) {      
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();        
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && i - hashMap.get(nums[i]) <= k) {
                return true;
            }
            hashMap.put(nums[i], i);
        }        
        return false;
    }
	
	/* HashSet
	 * */
	
    /*public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                hashSet.remove(nums[i - k - 1]);
            }
            if (!hashSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    }*/	
}
