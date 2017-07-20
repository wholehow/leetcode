package linked_list;

/* ���⣺
 * дһ��������ɾ��һ���������е�һ���ڵ㣨����β�ڵ㣩��ֻ��������ڵ㡣
 * ������һ������ 1->2->3->4�������������ֵΪ3�Ľڵ㣬�ڵ�����ĺ���֮���������Ӧ�ñ��1->2->4��
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution237 {
	
	/* һ������ɾ��һ�������ڵ㣬ֱ�ӽ�����һ���ڵ��nextָ������һ���ڵ�Ϳ����ˣ�
	 * ��������ֻ�����˸ýڵ㱾����Ҳ����˵��ֻ�ܻ�ȡ���ýڵ㱾���Լ�����һ���ڵ㡣
	 * ��ô��ֻ�ܽ��ýڵ�ֱ�ӱ����һ���ڵ��ˣ�����ֵ��Ϊ��һ���ڵ��ֵ������nextָ����һ���ڵ��next���Ϳ����ˡ�
	 * */
	
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}