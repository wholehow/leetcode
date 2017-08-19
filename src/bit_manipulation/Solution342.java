package bit_manipulation;

/* ����:
 * ����һ�����֣��з���32λ����дһ��������������ǲ���4�Ĵη�����
 * ���ӣ� ���� num = 16������true������ num = 15������false��
 * ���ף����ܲ��ܲ���ѭ�����ߵݹ����������
 * */

public class Solution342 {
	
	/* 4�Ķ�����Ϊ100��16�Ķ�����Ϊ10000��
	 * ���λΪ1�����඼��0��
	 * */
	
    public boolean isPowerOfFour(int num) {
        if (num < 0) {
        	return false;
        }
        String binaryStr = Integer.toBinaryString(num);
        if (binaryStr.length() % 2 != 1) {
        	return false;
        }
        for (int i = 0; i < binaryStr.length(); i++) {
        	if (i == 0 && binaryStr.charAt(i) != '1') {
        		return false;
        	}
        	if (i > 0 && binaryStr.charAt(i) != '0') {
        		return false;
        	}
        }
        return true;
    }
    
    /*���ö���*/
    /*public boolean isPowerOfFour(int num) {
        return (num > 0 && (Math.log10(num) / Math.log10(4)) % 1 == 0);
    }*/
}
