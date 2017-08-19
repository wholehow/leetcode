package hash_table;

import java.util.HashMap;
import java.util.Map;

/* ����ͽ���TinyURL��
 * TinyURL��һ��URL���̷������������������https://leetcode.com/problems/design-tinyurl��URL��
 * ������һ����̵�URL������http://tinyurl.com/4e9iAk��
 * ���TinyURL����ı���ͽ��뷽�����Ա���/�����㷨�Ĺ�����ʽû���κ����ơ���ֻ��ȷ����URL����Ϊһ��С��URL��������С��URL����ΪԭʼURL��
 * */

public class Solution535 {
	
	/* BASE_HOST = "http://tinyurl.com/"������ֻ��Ҫ�ҵ�BASE_HOST*��*�Ĳ��֡�
	 * 4e9iAk���ǿ�����Ϊ���������ĸ+���ֱ������ɵ����룬����random���������׿���ʵ�֡�
	 * */
	
	// ����bitHashMap��mapKeyVal��mapValKey�ֱ�ʵ��key��val����λ�ô洢��
	Map<String, String> mapKeyVal = new HashMap<String, String>();
	Map<String, String> mapValKey = new HashMap<String, String>();
	private static String BASE_HOST = "http://tinyurl.com/";
	
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (mapValKey.containsKey(longUrl)) {
        	return BASE_HOST + mapValKey.get(longUrl);
        }
        String chs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
        	StringBuilder sBuilder = new StringBuilder();
        	// ����6λ���������
        	for (int i = 0; i < 6; i++) {
        		int ran = (int) (Math.random() * chs.length());
        		sBuilder.append(chs.charAt(ran));
        	}
        	key = sBuilder.toString();
        } while (mapKeyVal.containsKey(key));
        
        // �����ӦmapKeyVal��key��mapValKey��val
        mapKeyVal.put(key, longUrl);
        mapValKey.put(longUrl, key);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mapKeyVal.get(shortUrl.replaceAll(BASE_HOST, ""));
    }
}

//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.decode(codec.encode(url));
