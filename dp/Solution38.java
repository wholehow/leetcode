package string;

/* ���⣺
 * �����Ǵ�������������п�ʼ�ģ�
 * 1, 11, 21, 1211, 111221, ...
 * 1 ����Ϊ "һ��1" ���� 11. 
 * 11 ����Ϊ "����1" ���� 21. 
 * 21 ����Ϊ "����2, Ȼ��һ��1" ���� 1211.
 * ����һ������n�����ɵ�n�����С�
 * ע�⣺����������Ҫʱ�ַ�������ʽ��
 * */

public class Solution38 {
	
	/* էһ����Ŀû����˼������֪���ˣ����ǿ���һ�����е����֣��������ʲô���Ӿ�дʲô���ӡ�
	 * n = 1ʱ����ӡһ��1��
	 * n = 2ʱ����n = 1��һ�У��1��1�����Դ�ӡ��11��
	 * n = 3ʱ����n = 2��һ�У��2��1�����Դ�ӡ��21��
	 * n = 4ʱ����n = 3��һ�У��һ��2һ��1�����Դ�ӡ��1211��
	 * �Դ����ơ�(ע������n�Ǵ�1��ʼ�ģ�
	 * */
	
	public String countAndSay(int n) {
	    if(n <= 0) {
	        return "";
	    }
	    String curStr = "1";
	    int start = 1;//��1��ʼ��
	    while(start < n){
	        StringBuilder res = new StringBuilder();
	        int count = 1;
	        for(int j=1;j<curStr.length();j++){
	            if(curStr.charAt(j)==curStr.charAt(j-1))
	                count++;
	            else{
	                res.append(count);
	                res.append(curStr.charAt(j-1));
	                count = 1;
	            }
	        }
	        res.append(count);
	        res.append(curStr.charAt(curStr.length()-1));
	        curStr = res.toString();
	        start++;
	    }
	    return curStr;
	}
}
