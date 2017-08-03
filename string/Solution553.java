package string;

/* 最佳划分
 * 给定一个正整数的列表，相邻的整数将执行浮点划分。例如，[2,3,4] - > 2/3/4。
 * 但是，你可以在任何位置添加任意数量的括号来更改操作的优先级。你应该找到如何添加括号以获取最大结果，并返回相应的字符串格式的表达式。
 * 你的表达式不应包含冗余圆括号。
 * 例如：
 * 输入：[1000,100,10,2]
 * 输出："1000/(100/10/2)"，
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * 然而，“1000 /（（100/10）/ 2）”中的粗体括号是多余的，因为它们不影响操作优先级。所以你应该返回“1000 /（100/10/2）”。
 * 注意：
 * 1.输入数组的长度为[1,10]。
 * 2.给定数组中的元素将在[2,1000]的范围内。
 * 3.每个测试用例只有一个最佳分区。
 * */

public class Solution553 {
	
	/* 给定的输入是有序的？如果默认有序直接解。
	 * 为了最大化a/b/c/d，必须先最小化b/c/d。
	 * (b/c)/d = b/c/d
	 * (b*d)/c < b/(d*c)
	 * d/c > 1/(d*c)显然成立，只要d>1
	 * 对于大于1的数字，第二个组合将始终小于第一个组合。
	 * */
	
    public String optimalDivision(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return null;
    	}
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                sBuilder.append("/(").append(nums[i]);
            } else {
                sBuilder.append("/").append(nums[i]);
            }
        }
        
        return nums.length > 2 ? sBuilder.append(")").toString() : sBuilder.toString();
    }
}
