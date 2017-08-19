package hash_table;

import java.util.HashMap;
import java.util.HashSet;

/* ���⣺
 * ����һ�����������һ��������k���ж��������Ƿ��κ�������һ����λ��i��j��
 * ��� nums[i] == nums[j] ��i��j�ľ��벻����k��
 * */

public class Solution219 {
	
	/* ����⿴�����򵥣������кܶ����壬�������k = 0����ô����������ζ��Ǵ�ġ�
	 * ��������в�����һ������������Ҳ�Ǵ�ġ�
	 * ��������д��ڶ��һ����ͬһ������ֻҪ����̵������ľ���С�ڵ���k�Ϳ����ˡ�
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
