package binary_search;

/* ���⣺
 * ����һ�������ź�����������飬�ҳ�����������ӵ���Ŀ�����֡�
 * ���� twoSum Ӧ�÷����������ֵ�������index1 ����С�� index2��
 * ��ע���㷵�صĽ����index1 �� index2�����ǻ���0��ʼ�ġ�
 * ����Լ���ÿ�����붼��һ�������
 * ���磺
 * ���룺numbers = {2, 7, 11, 15}, target = 9 
 * �����index1 = 1, index2 = 2
 */

public class Solution167 {
	
	/* �����������˫ָ�뷨���ˣ�ֻ��Ҫ����һ���������������
	 * ����һ��˼·���ڱ����Ĺ�����ʹ�ö��ֲ��ң���������ʱ�临�Ӷȴ�O(N)��ΪO(NlogN)��
	 * */
	
	/*���ֵ�˼��
	 * �ȹ̶���һ����������Ϊnums[0], ��ô���±�Ϊ1 .. n - 1�Ͻ��ж��ֲ��ң�������û��ֵΪtarget - nums[0]��
	 * �̶���һ����Ϊnums[1], �� 2 .. n - 1�϶��ֲ��ҡ�
	 */
	
	 public int[] twoSum(int[] numbers, int target) {
		 if (numbers == null || numbers.length < 2) {
			 return null;
		 }
		 int[] res = new int[2];
		 int right = numbers.length - 1;
		 for (int i = 0; i < numbers.length; i++) {
			 int tmp = target - numbers[i];
			 int left = i + 1;
			 while (left < right) {
				 int mid = left + (right - left) / 2;	//��ע������mid���±���㲻ͬ�ڱ�׼�Ķ���mid
				 if (numbers[mid] == tmp) {
					 res[0] = i + 1;
					 res[1] = mid;
					 return res;
				 } else if (numbers[mid] < tmp) {
					 left = mid + 1;
				 } else {
					 right = mid;
				 }
			 }
		 }
		 return null;
	 }
	
	/*˫ָ���˼��*/
    /*public int[] twoSum(int[] numbers, int target) {
    	//��Ҫʹ���ж�����target < 0����Ϊȷʵ����������Ĳ�������T-T
    	if (numbers == null || numbers.length < 2) {	
            return null;
        }
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }*/
}
