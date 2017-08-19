package array;

/* 大意：
 * 旋转一个有n个元素的数组，右移k步。
 * 比如，n = 7，k = 3，数组 [1,2,3,4,5,6,7] 就被旋转为 [5,6,7,1,2,3,4]。
 * */

public class Solution189 {
	
	/* 感谢代数学让我想到了取反的方法。(A-1)-1 = A。
	 * 思路是先把前n-k个数字翻转一下，再把后k个数字翻转一下，最后再把整个数组翻转一下。
	 * */
	
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;	//因为给出的k确实有可能会大于数组长度，所以这里必须使用取余操作，以找到真正的右移位置。
        reverse(nums, 0, nums.length - k - 1);	//不能使用reverse(nums, 0, k);
        reverse(nums, nums.length - k, nums.length - 1);	//不能使用reverse(nums, k + 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
        /* 这里也可以使用另外一种思路。
         * 感觉这样更好理解啊哈哈。
         * */
        /*reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);*/
    }
    private void reverse(int[] nums, int i, int j){
        int tmp = 0;       
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
