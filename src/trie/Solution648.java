package trie;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

/* 英文中，以较短的单词为前缀，可以构成较长的单词。此时前缀可以称为“词根”。
 * 给定一组词根字典dict，一个句子sentence。将句中的单词换为字典中出现过的最短词根。
 * 输入：dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * */

public class Solution648 {
	
	/* 反复求子串
	 * */
	
    /*public String replaceWords(List<String> dict, String sentence) {
    	if (dict == null || dict.size() == 0) 
    		return sentence;
    	Set<String> set = new HashSet<String>();
    	StringBuilder sBuilder = new StringBuilder();
    	
    	for (String string : dict) {
    		set.add(string);
    	}
    	String[] words = sentence.split("\\s+");
    	
    	for (String word : words) {
    		String prefix = "";
    		for (int i = 1; i <= word.length(); i++) {
    			prefix = word.substring(0, i);
    			if (set.contains(prefix)) 
    				break;
    		}
    		sBuilder.append(" " + prefix);
    	}
    	return sBuilder.deleteCharAt(0).toString();
    }*/
	
	/* 参考别人代码，字典树
	 * */
	
	public static class TrieNode {
		char val;
        TrieNode[] children;	// children是一个数组形式
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
	}
	
	public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        TrieNode trie = buildTrie(dict);
        return replaceWords(tokens, trie);
    }

    private String replaceWords(String[] tokens, TrieNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String token : tokens) {
            stringBuilder.append(getShortestReplacement(token, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private String getShortestReplacement(String token, final TrieNode root) {
        TrieNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : token.toCharArray()) {
            stringBuilder.append(c);
            if (temp.children[c - 'a'] != null) {
                if (temp.children[c - 'a'].isWord) {
                    return stringBuilder.toString();
                }
                temp = temp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for (String word : dict) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {	// 特殊处理'a'
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }
}
