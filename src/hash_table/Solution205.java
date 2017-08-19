package hash_table;

/* 大意：
 * 同构字符串。
 * 给定两个字符串s和t，确定它们是否是同构的。如果s中的字符可以被替换得到t，则两个字符串是同构的。
 * 字符的所有出现必须用另一个字符代替，同时保留字符的顺序。没有两个字符可能映射到同一个字符，但一个字符可能映射到自己。
 * 例如：“egg”和“add”同构，“paper”和“title”同构，“foo”和“bar”不同构。
 * 你可以假设s和t都有相同的长度。
 * */

public class Solution205 {
	
	/* 考虑问题本质，s和t同构：
	 * 1.有相同种类的字符；
	 * 2.每种字符个数相同；
	 * 3.每个位置对应的字符其种类对应的时候，字符个数整体还需要对应。
	 * 因此用数组模拟Map，运用平移的小技巧。
	 * 主要的想法是将当前（第i）个字符的最后看到的位置存储在两个字符串中。
	 * 如果先前存储的位置不同，那么我们知道它们同时发生在当前第i个位置会产生一个错误。
	 * */
	
    public boolean isIsomorphic(String s, String t) {
        // 存储每个（当前）字符最后一次出现的位置
    	int[] map = new int[512];	//  the length of ASCII is 256
        for (int i = 0; i < s.length(); i++) {
        	if (map[s.charAt(i)] != map[t.charAt(i) + 256]) {
        		return false;
        	}
        	map[s.charAt(i)] = map[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
