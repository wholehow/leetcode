package string;

import java.util.ArrayList;
import java.util.List;

/* ��дһ������������ֵ��ַ�����ʾ��1��n��
 * 3�ı��������Fizz����5�ı��������Buzz����15�ı��������FizzBuzz����
 * */

public class Solution412 {
	
	/* ����1��ȡ�������
	 * */
	
/*    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
        	if (i % 3 == 0 && i %5 == 0) {
        		res.add("FizzBuzz");
        	} else if (i % 3 == 0) {
        		res.add("Fizz");
        	} else if (i % 5 == 0) {
        		res.add("Buzz");
        	} else {
        		res.add(String.valueOf(i));
        	}
        }
        return res;
    }*/
	
/*	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";
	private static final String FIZZ_BUZZ = "FizzBuzz";

	public List<String> fizzBuzz(int n) {
	    List<String> res = new ArrayList<String>();
	    for(int i = 1; i <= n; i++){
	        String temp = i % 15 == 0 ? FIZZ_BUZZ : (i % 3 == 0 ? FIZZ : (i % 5 == 0 ?  BUZZ : String.valueOf(i)));
	        res.add(temp);
	    }
	    return res;
	}*/
	
	/* �������������ʵ�������ȡ������ͬ����
	 * */
	
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>(n);
        for(int i = 1, fizz = 0, buzz = 0; i <= n ; i++){
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                res.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                res.add("Buzz");
                buzz = 0;
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
