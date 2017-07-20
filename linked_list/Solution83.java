package linked_list;

/* ���⣺
 * ����һ���ź��������ɾ�����е��ظ������֣���ÿ��Ԫ��ֻ����һ�Ρ� 
 * ���磺 ���� 1->1->2, ����1->2. 
 * ����1->1->2->3->3, ����1->2->3.
 * */

public class Solution83 {
	
	/* 1.�������׽ڵ�Ϊ�յ����Ҫ���ǣ�
	 * 2.�����ֻ�е���ǰ���ֺ���һ�����ֲ�һ��ʱ�ŰѲ����Ľڵ㻻����һ���ڵ�ȥ��������������Ϊ�п����ж���ظ������ִ���һ��
	 * ����ɾ��һ���ڵ���ֱ�������ƽ����жϣ�Ҫ�ж�ɾ��һ���Ժ���һ���Ƿ���һ����
	 * 3.����������󼸸����ֶ����ظ��ģ������ڼ�⵽�ظ�������ʱ��ɾ����Ȼ�󽫵�ǰ�ڵ��nextָ��next��next��
	 * ��������Ҫע���ж�next�Ƿ���next�����û��ȴ���в������Ǿͻ�����ˡ�
	 * */
	
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
        	return head;
        }
        ListNode node1 = head;
        while (node1.next != null) {
            ListNode node2 = node1.next;
            if (node2.val == node1.val) {
                if (node2.next != null) {
                    node1.next = node2.next;
                } else { 
                	node1.next = null;
                }
            } else {
            	node1 = node1.next;
            }
        }
        return head;
    }
}
