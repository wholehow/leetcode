package math;

/* ���������ӷ���
 * ���磺 a = "11" b = "1" ���� "100".
 * */

public class Solution67 {
	
	/* ���ĳһλ����������0���������һλҲΪ0����һ��1����1��
	 * �������1����һλ��0�����н�һλ�������������������Ҫ���ǵ�λ��û�н�λ��
	 * ��Ϊ�������������ĳ��ȿ��ܲ�ͬ������������Ҫ��һ��ѭ����ȥ���������ĺͣ�����һ����������֮���ٿ�ʣ���ĸ�������ӵ������ȥ��
	 * */
	
	public String addBinary(String a, String b) {
        int flag = 0;
        char[] res = new char[a.length() > b.length() ? a.length() : b.length()]; 
        int k = res.length - 1;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--, k--) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                res[k] = flag == 1 ?  '1' : '0';
                flag = 1;
            } else if (a.charAt(i) == '1' || b.charAt(j) == '1') {
                res[k] = flag == 1 ? '0' : '1';
                flag = flag == 1 ? 1 : 0;
            } else {
                res[k] = flag == 1 ? '1' : '0';
                flag = 0;
            }
        }
        if (i >= 0) {
            for (; i >=0; i--, k--) {
                if (a.charAt(i) == '1' && flag == 1) {
                    res[k] = '0';
                    flag = 1;
                } else if (a.charAt(i) == '1' || flag == 1) {
                    res[k] = '1';
                    flag = 0;
                } else {
                    res[k] = '0';
                    flag = 0;
                }
            }
        }
        if (j >= 0) {
            for (; j >=0; j--, k--) {
                if (b.charAt(j) == '1' && flag == 1) {
                    res[k] = '0';
                    flag = 1;
                } else if (b.charAt(j) == '1' || flag == 1) {
                    res[k] = '1';
                    flag = 0;
                } else {
                    res[k] = '0';
                    flag = 0;
                }
            }
        }
        return flag == 1 ? "1" + String.valueOf(res) : String.valueOf(res);
    }
}
