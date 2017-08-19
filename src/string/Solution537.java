package string;

/* �����˷�
 * ����������ʾ�����������ַ���������Ҫ����һ����ʾ���ǵĳ˷����ַ�����
 * ���磺
 * ���룺"1+1i", "1+1i"
 * �����"0+2i"
 * */

public class Solution537 {
	
	/* �ܼ򵥵���Ŀ��
	 * дһ������getValue���ڻ�ȡ��Ч�������֣�i����Ҫ���㣬����ֻ֪�����ǵڶ����֣���˻������ʱΪ-1���ɣ���
	 * */
	
    public String complexNumberMultiply(String a, String b) {
        int[] valA = getValue(a);
        int[] valB = getValue(b);
        // ʵ��
        int real = valA[0] * valB[0] - valA[1] * valB[1];
        // �鲿
        int img = valA[0] * valB[1] + valA[1] * valB[0];
        return real + "+" + img + "i";
    }
    
    private int[] getValue(String str) {
    	// ע��������ʽ����д
    	String[] strs = str.split("\\+|i");
    	int[] val = new int[2];
    	val[0] = Integer.parseInt(strs[0]);
    	val[1] = Integer.parseInt(strs[1]);
    	return val;
    }
}
