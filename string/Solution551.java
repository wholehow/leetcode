package string;

/* ���⣺
 * ����һ���ַ���s�������е�'A'����1�������߳���������3����3������'L'������False�����򷵻�True
 * */

public class Solution551 {
	
	/* ͵����ʹ������
	 * */
	
    public boolean checkRecord(String s) {
        return !s.matches(".*A.*A.*") && !s.matches(".*LLL.*");
    }
    
    /*��Ȼ������ʹ��ɨ�跨*/
   /* public boolean checkRecord(String s) {  
        int cntA = 0;  //��¼���ֵ�A
        int cntL = 0;  //��¼����������L
        for (int i = 0; i < s.length(); i++) {  
            if (s.charAt(i) == 'P') {  
            	cntL = 0;  
                continue;  
            } else if (s.charAt(i) == 'A') {  
            	cntL = 0;  
                cntA++;  
                if (cntA > 1) { 
                    return false;  
                }
            } else {  
            	cntL++;  
                if (cntL > 2) { 
                    return false;  
                }
            }  
        }  
        return true;  
    } */
}
