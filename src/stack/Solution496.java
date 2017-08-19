package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* ���⣺
 * �����������飨���ظ���nums1 �� nums2������nums1��Ԫ����nums2���Ӽ���
 * ��nums2��Ѱ�Ҵ���nums1�ж�Ӧλ���Ҿ��������Ԫ�ء������Ӧλ�ò�����������Ԫ�أ������-1��
 * 
 * ���磺
 * ���룺nums1 = [4,1,2], nums2 = [1,3,4,2]
 * �����[-1,3,-1]������ nums1�е�4���޷���nums2���ҵ����������������-1��
 * nums1�е�1��nums2�ж�Ӧλ�õ�һ�������������3��
 * nums1�е�2��nums2�ж�Ӧλ��û�б��������������-1��
 * 
 * ���룺nums1 = [2,4], nums2 = [1,2,3,4]
 * �����[3,-1]������nums1�е�2��nums2�ж�Ӧλ�õ�һ�������������3��
 * nums1�е�4��nums2���޷��ҵ����������������-1��
 * */

public class Solution496 {
	
	/* ˼·һ�������ⷨ
	 * ����nums1����ÿһ�������ҵ�����nums2��λ�ã�Ȼ������λ�ÿ�ʼ��������
	 * ������ҵ�������ģ��ͼ��µ�һ������������������Ϊ-1��
	 * */
	
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
    	
        int len1 = findNums.length;
        int len2 = nums.length;
        int[] res = new int[len1];

        for (int i = 0; i < len1; i++) {
            int curNum = findNums[i];
            //����ʹ��һ������������Ƕ����ԣ��о����������Ȼ������⵫�Ƕ���
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
            boolean startFlag = false;	//�Ա�λ�ñ��
            boolean findFlag = false;	//���������
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
    
    /* ˼·2��ʹ��HashMap
     * �洢nums2ÿ�����Լ����ֵ�λ�ã�Ȼ������nums1�ڶ�Ӧ��λ��Ѱ���Ƿ���������������Լ�����Ƿ���ڸ������
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
    
    /* ˼·3��HashMap��Stack
     * Ĥ��һ��д����ô������Ĵ���
     * */
    
    /*public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
        	//�Ȱ�nums2��ÿ�����͵�һ������������Ĺ�ϵ��ȷ����
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);	//��key=��valueС�ĵ�һ������value=nums2�е�����
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);	//key����nums2�е�һ����nums1��Ӧλ�õ��������
        return findNums;
    }*/
}
