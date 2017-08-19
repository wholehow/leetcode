package trie;

import java.util.HashSet;
import java.util.Set;

/* �����ǿ���������, a0, a1, a2, �� , an-1,0 �� ai < 2^31.
 * �ҵ�ai XOR aj���������
 * ���磺
 * ���룺[3, 10, 5, 25, 2, 8]
 * �����28�����Ľ����5 ^ 25 = 28
 * */

public class Solution421 {
	
	/* �������
	 * ���a ^ b = c, ��ôa ^ c = b.
	 * ��������������Ǵ����λ��ʼ�ң������Ƚ������������λ�浽һ��Set�С�Ȼ�����Ǽ������մ𰸵����λΪ1��
	 * �������������������λ��1����������㣬���õ��Ľ����Ȼ��Set�У���ô˵�����մ𰸵����λһ��Ϊ1
	 * (�ɶ���ɵ�1 ^ x = b <==> b ^ x = 1��������x��һ������һ����b��ʹ��x ^ b = 1)���������λ�Ĵ�һ��Ϊ0��
	 * ���������Ѿ�֪�����մ𰸵����kλΪprefix�������Ƚ������������������k+1λ����Set�С�
	 * Ȼ�����Ǽ�����һλ��ֵΪ1���������������������k+1λ��prefix*2 + 1����������㣬������õ��Ľ����Ȼ��Set�У�
	 * ��ô˵�����մ𰸵ĵ�k+1λһ��Ϊ1���������λ�Ĵ�һ��Ϊ0��
	 * ����[14, 11, 7, 2]<==>[1110, 1011, 0111, 0010]���������Ϊ��ֻ�ӵ�4λ��i=3��ʼ��ǰ��ȫ��0��
	 * 1.i = 3, set = {1000, 0000}, max = 1000
	 * 2.i = 2, set = {1100, 1000, 0100, 0000}, max = 1100
	 * 3.i = 1, set = {1110, 1010, 0110, 0010}, max = 1100
	 * 4.i = 0, set = {1110, 1011, 0111, 0010}, max = 1100
	 * */
	
    /*public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {	// �����λ��ʼ����Ӧ���������󣩣����������ĿǰΪֹ���ǵ�������λ
            mask |= (1 << i);	//1xx1xxx0000xxx
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);	// �������λ�������ұ�λ
            }
            int tmp = max | (1 << i);	// ��ÿ�ε����У�����������λ�������õ����ֵ
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
            children = new TrieNode[2];	// 0��1
        }
	}
	
	public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // ��ʼ��Trie
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
        // �ҵ����ֵ
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
