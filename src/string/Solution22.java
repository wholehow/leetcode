package string;

import java.util.List;
import java.util.ArrayList;

/* �������š�
 * ����n�����ţ�дһ��������������ʽ���õ����ŵ�������ϡ�
 * ���磺
 * ���룺 n = 3
 * �����[
  		"((()))",
  		"(()())",
  		"(())()",
  		"()(())",
  		"()()()"
		]
 * */

public class Solution22 {
	
	/* ���ݷ���
	 * ���κ�ʱ�̣����Ƕ�������ѡ��
	 * 1.��������
	 * 2.��������
	 * ���κ�ʱ�̣����Ƕ����������ƣ�
	 * 1.����������Ѿ������ˣ������ټ��������ˡ�
	 * 4.����Ѿ����ֵ������ź�������һ���࣬�����ټ��������ˡ���Ϊ�����Ļ��¼����������һ���޷�ƥ�䡣
	 * */
	
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack("", res, n, n);
        return res;
        
    }
    private void backtrack(String subList, List<String> res, int left, int right) {
    	// �������Ŷ��Ѿ�����
    	// �������������Ժ�һ������ȷ�⡣��Ϊ1. ��������һ���࣬2. ÿ�������Ŷ�һ������֮��Ե������š����һ�������Ϳ��Լ���⼯
    	if (left == 0 && right == 0) {
    		res.add(subList);
    		return;
    	}
    	// ÿ�ζ����ȼ����ټ��ң������ܲ�����left > right
    	if (left > right) {
    		return;
    	}
    	// ����ʣ��
    	if (left > 0) {
    		backtrack(subList + "(", res, left - 1, right);
    	}
    	// �һ���ʣ��
    	if (right > 0) {
    		backtrack(subList + ")", res, left, right - 1);
    	}
    }
}
