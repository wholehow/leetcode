package trie;

import java.util.HashSet;
import java.util.Set;

/* 给定非空整数数组, a0, a1, a2, … , an-1,0 ≤ ai < 2^31.
 * 找到ai XOR aj的最大结果。
 * 例如：
 * 输入：[3, 10, 5, 25, 2, 8]
 * 输出：28，最大的结果是5 ^ 25 = 28
 * */

public class Solution421 {
	
	/* 利用异或。
	 * 如果a ^ b = c, 那么a ^ c = b.
	 * 根据这个定理，我们从最高位开始找，我们先将所有数的最高位存到一个Set中。然后，我们假设最终答案的最高位为1，
	 * 将数列中所有数的最高位和1进行异或运算，异或得到的结果仍然在Set中，那么说明最终答案的最高位一定为1
	 * (由定理可得1 ^ x = b <==> b ^ x = 1，对于数x，一定存在一个数b，使得x ^ b = 1)，否则最高位的答案一定为0。
	 * 假设我们已经知道最终答案的最高k位为prefix，我们先将数列中所有数的最高k+1位存入Set中。
	 * 然后，我们假设下一位的值为1，将数列中所有数的最高k+1位与prefix*2 + 1进行异或运算，如果异或得到的结果仍然在Set中，
	 * 那么说明最终答案的第k+1位一定为1，否则最高位的答案一定为0。
	 * 比如[14, 11, 7, 2]<==>[1110, 1011, 0111, 0010]，具体过程为（只从第4位即i=3开始，前面全是0）
	 * 1.i = 3, set = {1000, 0000}, max = 1000
	 * 2.i = 2, set = {1100, 1000, 0100, 0000}, max = 1100
	 * 3.i = 1, set = {1110, 1010, 0110, 0010}, max = 1100
	 * 4.i = 0, set = {1110, 1011, 0111, 0010}, max = 1100
	 * */
	
    /*public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {	// 从最高位开始（对应二进制最左），掩码包含到目前为止考虑到的所有位
            mask |= (1 << i);	//1xx1xxx0000xxx
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);	// 保留左边位并忽略右边位
            }
            int tmp = max | (1 << i);	// 在每次迭代中，存在左对齐的位可以异或得到最大值
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }*/
	
	public static class TrieNode{
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];	// 0和1
        }
	}
	
	public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // 初始化Trie
        TrieNode root = new TrieNode();
        for (int num: nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i --) {
                int bitCount = (num >>> i) & 1;
                if (node.children[bitCount] == null) {
                    node.children[bitCount] = new TrieNode();
                }
                node = node.children[bitCount];
            }
        }
        // 找到最大值
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            TrieNode node = root;
            int sum = 0;
            for (int i = 31; i >= 0; i --) {
                int bitCount = (num >>> i) & 1;
                if (node.children[bitCount ^ 1] != null) {
                    sum += (1 << i);
                    node = node.children[bitCount ^ 1];
                } else {
                    node = node.children[bitCount];
                }
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
