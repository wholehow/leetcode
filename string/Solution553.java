package string;

/* ��ѻ���
 * ����һ�����������б����ڵ�������ִ�и��㻮�֡����磬[2,3,4] - > 2/3/4��
 * ���ǣ���������κ�λ������������������������Ĳ��������ȼ�����Ӧ���ҵ������������Ի�ȡ���������������Ӧ���ַ�����ʽ�ı��ʽ��
 * ��ı��ʽ��Ӧ��������Բ���š�
 * ���磺
 * ���룺[1000,100,10,2]
 * �����"1000/(100/10/2)"��
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * Ȼ������1000 /����100/10��/ 2�����еĴ��������Ƕ���ģ���Ϊ���ǲ�Ӱ��������ȼ���������Ӧ�÷��ء�1000 /��100/10/2������
 * ע�⣺
 * 1.��������ĳ���Ϊ[1,10]��
 * 2.���������е�Ԫ�ؽ���[2,1000]�ķ�Χ�ڡ�
 * 3.ÿ����������ֻ��һ����ѷ�����
 * */

public class Solution553 {
	
	/* ����������������ģ����Ĭ������ֱ�ӽ⡣
	 * Ϊ�����a/b/c/d����������С��b/c/d��
	 * (b/c)/d = b/c/d
	 * (b*d)/c < b/(d*c)
	 * d/c > 1/(d*c)��Ȼ������ֻҪd>1
	 * ���ڴ���1�����֣��ڶ�����Ͻ�ʼ��С�ڵ�һ����ϡ�
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
