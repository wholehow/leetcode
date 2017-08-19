package hash_table;

import java.util.List;
import java.util.ArrayList;

/* ���⣺
 * ����һ���ַ���s��һ���ǿ��ַ���p��Ѱ��s������p�����ձ任����ʼ�±ꡣ
 * �ַ���ֻ����СдӢ����ĸ����s��p�ĳ��Ⱦ�������20100��
 * ���˳������ν��
 * ���磺
 * ���룺s: "cbaebabacd" p: "abc"
 * �����[0, 6]����ʼindex = 0���Ӵ��ǡ�cba�������ǡ�abc�������ձ任����ʼindex = 6���Ӵ��ǡ�bac�������ǡ�abc�������ձ任��
 * ���룺s: "abab" p: "ab"
 * �����[0, 1, 2]����ʼindex = 0���Ӵ��ǡ�ab�������ǡ�ab�������ձ任����ʼindex = 1���Ӵ��ǡ�ba�������ǡ�ab�������ձ任��
 * ��ʼindex = 2���Ӵ��ǡ�ab�������ǡ�ab�������ձ任��
 * */

public class Solution438 {
	
	/* �о������Ŀͦ�ѵģ�һֱ�벻����ȡ�ͺ󲹵ķ�����
	 * �ַ�ͳ�ƣ����ʵ����ձ任��anagram����ָ������ĸ������ֻͬ��˳��ͬ�ĵ��ʡ�
	 * */
	
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
        	return list;
        }
        // ������ģ��HashMap�����Լ򻯲���
        int[] hash = new int[128];
        for (char letetr : p.toCharArray()) {
        	hash[letetr]++;
        }
        // ��ʼcntΪp��length����ÿƥ��һ����cnt�Լ�1��
        int start = 0, end = 0, cnt = p.length();
        while (end < s.length()) {
        	// �ҵ��ˣ��Ͱѱ�ʾҪ�жϵ��ַ������ȼ�һ
        	if (hash[s.charAt(end)] >= 1) {
        		cnt--;
        	}
        	// ������û���ҵ�����Ҫ��������٣��ұ�־λ���ƣ�����Ϊ��֮������жϣ���Ϊ����Ҫ�ҵĵ��ַ���ʼ�մ������־λ���ұ�־λ���м�
        	hash[s.charAt(end)]--;
        	end++;
        	// cnt=0ʱ˵��s���Ե�ǰ�ַ���ʼ��cnt��λ��������������
        	if (cnt == 0) {
        		list.add(start);
        	}
        	// �����ڻ������ڣ����¹����±�
        	if (end - start == p.length()) {
        		// �ҵ�����Ҫ��count��������1
        		if (hash[s.charAt(start)] >= 0) {
        			cnt++;
        		}
        		// ������û���ҵ�������Ҫ�������еĶ�Ӧ����ĸ��������1��
        		hash[s.charAt(start)]++;
        		start++;
        	}
        }
        return list;
    }
}
