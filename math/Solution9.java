package math;

/* �ж�һ�������Ƿ��ǻ�������
 * ��ʹ�ö���Ŀռ�����ɡ�
 * */

public class Solution9 {
	
	/* ��һ��˼·
	 * ��Ŀֻ˵��ʹ�ö���Ŀռ䣬��ʵ�����������ʹ��String����ʵ��Ҳ���Ǻܶ�����ȷʵ����AC�ˣ���
	 * ����ֱ�ӱȽ����ֲ�̫�ñȽϣ��Ƚ���תΪ�ַ�����Ȼ�����αȽ��ַ�����һλ�����һλ���ڶ�λ�͵����ڶ�λ�ȵȵ��ַ��ǲ���һ���ģ�
	 * ����ֻ��Ҫ�Ƚϵ��ַ�������һ���λ�þͿ����ˡ�
	 * ��Ŀ�Ƚϵ��۵��趨�ǣ���Ŀ��ֻ˵��������û˵�������������Ĵ��жϸ���ͳͳ���ǻ��ģ���ʹ��-121����Ҳ���С�
	 * */
	
    /*public boolean isPalindrome(int x) {
        if (x < 0) {
        	return false;
        }
        String xStr = String.valueOf(x);
        for (int i = 0; i < xStr.length() / 2; i++) {
            if (xStr.charAt(i) != xStr.charAt(xStr.length() - 1 - i)) {
            	return false;
            }
        }
        return true;
    }*/
	
	/* �ڶ���˼·��ֻҪ������ĩβΪ0�ģ�Ҳ����˵����10������Ϊ0����һ�����ǻ��ģ���Ϊ���������λ��0�
	 * ������һ�����ͱ�������¼x�����������һ��ʱ������
	 * ��ԭ����x��һ����ת���ɴ������Ҷ�һ�������
	 * ��󿴿��������ǲ�����ȣ�����Ϊ�п����м��е���һ���������Ի��п����ǳ���ʮ�Ժ���ȡ�
	 * */
	
	/*public boolean isPalindrome(int x) {
	    if (x < 0 || ( x != 0 && x % 10 == 0)) {
	    	return false;
	    }
	    int rev = 0;
	    while (x > rev){
	    	rev = rev * 10 + x % 10;	//���ҵ���
	    	x = x / 10;					//������
	    }
	    return (x == rev || x == rev / 10);		//�п����м��е���һ���������Ի��п����ǳ���ʮ�Ժ����
	}*/
	
	/* ������˼·���Ҿ�������õġ�
	 * �����ַ������ļ�鷽����ÿ��ȡ��x�����λ�����λ�Ƚϡ�
	 * ��������һ��baseΪ10^n������ȡ�����λ������ÿ��ѭ������100����Ϊÿ��x����ȥ2λ��
	 * */
	
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int base = 1;
		while (x / base >= 10) {
			base *= 10;
		}
		while (x > 0) {
			int leftDigit = x / base;
			int rightDigit = x % 10;
			if (leftDigit != rightDigit) {
				return false;
			}
			x = (x % base) / 10; // x -= base * leftDigit
			base /= 100;
		}
		return true;
	}
}
