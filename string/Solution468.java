package linked_list;

/* 编写一个函数来检查输入字符串是否是有效的IPv4地址或IPv6地址，或者两者都不是。
 * */

public class Solution468 {
	
	/* 写两个方法isValidIPv4判断是否是有效的IPv4，isValidIPv6判断是否是有效的IPv6。
	 * 由于IPv4和IPv6都是以"."作为划分的依据，因此需要两个额外的方法isValidIPv4Token和isValidIPv6Token来判断
	 * token（就是每个被"."分开的部分）是否是合法的。
	 * */
	
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) {
        	return "IPv4";
        } else if (isValidIPv6(IP)) {
        	return "IPv6";
        } else {
        	return "Neither";
        }
    }
    
    private boolean isValidIPv4(String IP) {
    	// 各种不合法的情况
    	if (IP.length() < 7 || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
    		return false;
    	}
    	// 注意：这里必须使用转义
    	String[] tokens = IP.split("\\.");
    	if (tokens.length != 4) {
    		return false;
    	}
    	for (String token : tokens) {
    		if (!isValidIPv4Token(token)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private boolean isValidIPv4Token(String token) {
    	// 01这种是不合法的
    	if (token.startsWith("0") && token.length() > 1) {
    		return false;
    	}
    	try {
    		// 将token转换为整数，它必须在0-255范围
    		int parsedInt = Integer.parseInt(token);
    		if (parsedInt < 0 || parsedInt > 255) {
    			return false;
    		}
    		if (parsedInt == 0 && token.charAt(0) != '0') {
    			return false;
    		}
    	} catch (NumberFormatException nfe) {
    		return false;
    	}
    	return true;
    }
    
    private boolean isValidIPv6(String IP) {
    	// 各种不合法的情况
    	if (IP.length() < 15 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
    		return false;
    	}
    	// 这里可以不用转义
    	String[] tokens = IP.split(":");
    	if (tokens.length != 8) {
    		return false;
    	}
    	for (String token : tokens) {
    		if (!isValidIPv6Token(token)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private boolean isValidIPv6Token(String token) {
    	if (token.length() == 0 || token.length() > 4) {
    		return false;
    	}
    	char[] chs = token.toCharArray();
    	for (int i = 0; i < chs.length; i++) {
    		// 0-9，a-f，A-F
    		if (!(Character.isDigit(chs[i]) || (chs[i] >= 'a' && chs[i] <= 'f') || (chs[i] >= 'A' && chs[i] <= 'F'))) {
    			return false;
    		}
    	}
    	return true;
    }
    
    /* 使用Java正则
     * */
    
    /*public String validIPAddress(String IP) {
        if (IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])")) return "IPv4";
        if (IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})")) return "IPv6";
        return "Neither";
    }*/
}
