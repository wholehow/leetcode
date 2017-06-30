package string;

/* 大意：
 * 序列是从下面的整型序列开始的：
 * 1, 11, 21, 1211, 111221, ...
 * 1 被称为 "一个1" 或者 11. 
 * 11 被称为 "两个1" 或者 21. 
 * 21 被称为 "两个2, 然后一个1" 或者 1211.
 * 给出一个整型n，生成第n个序列。
 * 注意：整型序列需要时字符串的形式。
 * */

public class Solution38 {
	
	/* 乍一看题目没懂意思，后来知道了，就是看上一个序列的数字，念出来是什么样子就写什么样子。
	 * n = 1时，打印一个1。
	 * n = 2时，看n = 1那一行，念：1个1，所以打印：11。
	 * n = 3时，看n = 2那一行，念：2个1，所以打印：21。
	 * n = 4时，看n = 3那一行，念：一个2一个1，所以打印：1211。
	 * 以此类推。(注意这里n是从1开始的）
	 * */
	
	public String countAndSay(int n) {
	    if(n <= 0) {
	        return "";
	    }
	    String curStr = "1";
	    int start = 1;//从1开始算
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
