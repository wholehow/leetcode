package linked_list;

/* ��дһ����������������ַ����Ƿ�����Ч��IPv4��ַ��IPv6��ַ���������߶����ǡ�
 * */

public class Solution468 {
	
	/* д��������isValidIPv4�ж��Ƿ�����Ч��IPv4��isValidIPv6�ж��Ƿ�����Ч��IPv6��
	 * ����IPv4��IPv6������"."��Ϊ���ֵ����ݣ������Ҫ��������ķ���isValidIPv4Token��isValidIPv6Token���ж�
	 * token������ÿ����"."�ֿ��Ĳ��֣��Ƿ��ǺϷ��ġ�
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
    	// ���ֲ��Ϸ������
    	if (IP.length() < 7 || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
    		return false;
    	}
    	// ע�⣺�������ʹ��ת��
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
    	// 01�����ǲ��Ϸ���
    	if (token.startsWith("0") && token.length() > 1) {
    		return false;
    	}
    	try {
    		// ��tokenת��Ϊ��������������0-255��Χ
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
    	// ���ֲ��Ϸ������
    	if (IP.length() < 15 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
    		return false;
    	}
    	// ������Բ���ת��
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
    		// 0-9��a-f��A-F
    		if (!(Character.isDigit(chs[i]) || (chs[i] >= 'a' && chs[i] <= 'f') || (chs[i] >= 'A' && chs[i] <= 'F'))) {
    			return false;
    		}
    	}
    	return true;
    }
    
    /* ʹ��Java����
     * */
    
    /*public String validIPAddress(String IP) {
        if (IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])")) return "IPv4";
        if (IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})")) return "IPv6";
        return "Neither";
    }*/
}
