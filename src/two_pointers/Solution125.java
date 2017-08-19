package two_pointers;

/* �ж�һ���ַ����Ƿ��ǻ��ġ�
 * 
 * ���磺
 * "A man, a plan, a canal: Panama" �ǻ��ġ�
 * "race a car" ���ǻ��ġ�
 * 
 * ע�⣺
 * ���п����ַ�������Ϊ������������ʱ��һ�������⡣
 * ����������Ŀ�ģ����Ǽ�����ַ���Ҳ����Ч�Ļ��ġ�
 * */

public class Solution125 {
	
	/* �������п��Կ����������ֻ�ж��ַ����еĴ�Сд��ĸ�����֣��ո�����������Ŷ���û����һ����Ҳ����������ʱ��Ҫ���ԡ�
	 * �����Сд��ĸ���ԣ���������ͬ�ģ���Ҳ����ζ�����ж��Ƿ���ͬʱҪ����Сд��ĸתΪͬһ����ʽ��
	 * ��Ϊֻ�ǿ�һ���ַ������㷨���ǱȽϼ򵥣����Ǵ���ͷ���������м��ߣ���������ƥ�䡣
	 * */
	
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
        	while (i < s.length() && !isValid(s.charAt(i))) {
        		i++;
        	}
        	if (i == s.length()) {	//��һ�仰���Ǻ���Ҫ�ģ������������",..."
        		return true;
        	}
        	while (j >= 0 && !isValid(s.charAt(j))) {
        		j--;
        	}
        	if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
        	i++;
        	j--;
        }
        return j <= i;
    }
    private boolean isValid(char c) {
    	return Character.isLetter(c) || Character.isDigit(c);
	}
}
