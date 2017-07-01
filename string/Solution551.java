package string;

/* 大意：
 * 给定一个字符串s，若其中的'A'大于1个，或者出现连续的3个或3个以上'L'，返回False，否则返回True
 * */

public class Solution551 {
	
	/* 偷个懒使用正则
	 * */
	
    public boolean checkRecord(String s) {
        return !s.matches(".*A.*A.*") && !s.matches(".*LLL.*");
    }
    
    /*当然还可以使用扫描法*/
   /* public boolean checkRecord(String s) {  
        int cntA = 0;  //记录出现的A
        int cntL = 0;  //记录出现连续的L
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
