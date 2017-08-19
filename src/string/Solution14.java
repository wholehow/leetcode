package string;

/* ���⣺
 * дһ��������Ѱ��һ��������ַ����������ͬǰ׺��
 * */

public class Solution14 {
	
	/* ��һ��д�˸��ǰ׺ƥ�䣬�����ô����ͨ��������~��ʵ����һ����Ŀ�����ǲ�����ϸ��T-T
	 * ��������һ���ַ���������ǰ׺ȥ�ж�ÿ���ַ����Ƿ�ӵ�и�ǰ׺��û�оͽ�����жϵ�ǰ׺ĩβ�ַ�ȥ���ٱȽϣ�
	 * ֱ����ǰ�жϵ��ַ��������ǰ׺�ˣ���ȥ�ж���һ���ַ�����û�У�ִ��ͬ���Ĳ�����
	 * ���κ�ʱ��ǰ׺���ȼ��ٵ�0�ˣ�Ҳ����ֱ�ӷ����ˡ�
	 * */
	
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";
        } else if (strs.length == 1) {
        	return strs[0];
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
        	while (strs[i].indexOf(pre) != 0) {
        		pre = pre.substring(0, pre.length() - 1);
        		if (pre.length() == 0) {
					return "";
				}
        	}
        }
        return pre;
    }
}
