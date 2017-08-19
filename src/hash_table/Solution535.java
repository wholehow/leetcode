package hash_table;

import java.util.HashMap;
import java.util.Map;

/* 编码和解码TinyURL。
 * TinyURL是一个URL缩短服务，你可以在其中输入https://leetcode.com/problems/design-tinyurl等URL，
 * 并返回一个简短的URL，例如http://tinyurl.com/4e9iAk。
 * 设计TinyURL服务的编码和解码方法。对编码/解码算法的工作方式没有任何限制。你只需确保将URL编码为一个小的URL，并将该小型URL解码为原始URL。
 * */

public class Solution535 {
	
	/* BASE_HOST = "http://tinyurl.com/"，我们只需要找到BASE_HOST*中*的部分。
	 * 4e9iAk我们可以认为是随机从字母+数字表中生成的密码，利用random函数很容易可以实现。
	 * */
	
	// 参照bitHashMap，mapKeyVal和mapValKey分别实现key和val互换位置存储。
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
        	// 生成6位的随机密码
        	for (int i = 0; i < 6; i++) {
        		int ran = (int) (Math.random() * chs.length());
        		sBuilder.append(chs.charAt(ran));
        	}
        	key = sBuilder.toString();
        } while (mapKeyVal.containsKey(key));
        
        // 密码对应mapKeyVal的key和mapValKey的val
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
