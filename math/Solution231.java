package math;

/* ���⣺
 * ����һ��������дһ�������ж����Ƿ���2�Ĵη�����
 * */

public class Solution231 {
	
	/* ������326��Ŀ���񣬵���������򵥣���Ϊ��һ�������ƵĶ������ڣ�
	 * ����Ҫ�ж�һ�����ǲ���2�Ĵη���������ȥһ�δγ���2��Ҳ������logȥ�㣬ֱ��ת���ɶ����ƣ�
	 * �����2�Ĵη�������һ�������λΪ1������λ��Ϊ0�Ķ�������������ֻ���ж�������������ǲ��Ƿ����������Ϳ����ˡ�
	 * */
	
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
        	return false;
        }
        String binaryStr = Integer.toBinaryString(n);
        for (int i = 0; i < binaryStr.length(); i++) {
            if (i == 0 && binaryStr.charAt(i) != '1') {
            	return false;
            } else if (i > 0 && binaryStr.charAt(i) != '0') {
            	return false;
            }
        }
        return true;
    }
}
