package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* 大意：
 * 给定两个数组（无重复）nums1 与 nums2，其中nums1的元素是nums2的子集。
 * 在nums2中寻找大于nums1中对应位置且距离最近的元素。如果对应位置不存在这样的元素，则输出-1。
 * 
 * 例如：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2]
 * 输出：[-1,3,-1]，解释 nums1中的4，无法在nums2中找到比它大的数，返回-1；
 * nums1中的1，nums2中对应位置第一个比它大的数是3；
 * nums1中的2，nums2中对应位置没有比它大的数，返回-1。
 * 
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4]
 * 输出：[3,-1]，解释nums1中的2，nums2中对应位置第一个比它大的数是3；
 * nums1中的4，nums2中无法找到比它大的数，返回-1。
 * */

public class Solution496 {
	
	/* 思路一：暴力解法
	 * 遍历nums1，对每一个数，找到它在nums2的位置，然后从这个位置开始向后遍历，
	 * 如果能找到比它大的，就记下第一个比它大的数，否则记为-1。
	 * */
	
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
    	
        int len1 = findNums.length;
        int len2 = nums.length;
        int[] res = new int[len1];

        for (int i = 0; i < len1; i++) {
            int curNum = findNums[i];
            //这里使用一个或者两个标记都可以，感觉两个标记虽然更好理解但是多余
            /*int len1 = findNums.length;
            int len2 = nums.length;
            int[] res = new int[len1];

            for(int i = 0; i < len1; i++){
                res[i] = -1;
                int curNum = findNums[i];
                boolean startFlag = false;

                for(int j = 0; j < len2; j++){
                    if(nums[j] == curNum){
                        startFlag = true;
                        continue;
                    }
                    if(startFlag && nums[j] > curNum){
                        res[i] = nums[j];
                        break;
                    }
                }
            }
            return res;
        }*/
            boolean startFlag = false;	//对比位置标记
            boolean findFlag = false;	//输出结果标记
            for (int j = 0; j < len2; j++) {
                if (nums[j] == curNum) {
                    startFlag = true;
                    continue;
                }
                if (startFlag && nums[j] > curNum) {
                    res[i] = nums[j];
                    findFlag = true;
                    break;
                }
            }
            if (!findFlag) {
                res[i] = -1;
            }
        }
        return res;
    }
    
    /* 思路2：使用HashMap
     * 存储nums2每个数以及出现的位置，然后利用nums1在对应的位置寻找是否存在这样的数，以及其后是否存在更大的数
     * */
    
    /*public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null ||  nums == null || findNums.length == 0 || nums.length == 0 
        		|| findNums.length > nums.length) {
        	return new int[0];
        }
        int m = findNums.length;
        int n = nums.length;
        int[] result = new int[m];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int j = 0; j < n; ++j){
            map.put(nums[j], j);
        }
        for (int i = 0; i < m; i++){
            int j = map.get(findNums[i]);
            for (; j < n; j++){
                if (nums[j] > findNums[i]) 
                	break;
            }
            result[i] = j < n ? nums[j] : -1;
        }
        return result;
    }*/
    
    /* 思路3：HashMap和Stack
     * 膜拜一下写出这么巧妙方法的大神
     * */
    
    /*public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
        	//先把nums2中每个数和第一个比它大的数的关系先确定好
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);	//（key=比value小的第一个数，value=nums2中的数）
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);	//key就是nums2中第一个比nums1对应位置的数大的数
        return findNums;
    }*/
}
