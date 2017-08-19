package linked_list;

/* ���⣺
 * �Ƴ�����������ֵΪval��Ԫ�ء�
 * ���磺
 * ����: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 
 * ����: 1 --> 2 --> 3 --> 4 --> 5
 * */

public class Solution203 {
	
	/* ������������ֵ��val��ͬ�ľ�ɾ���ڵ�ͺ�
	 * */
	
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode node = newHead;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } 
            else {
                node = node.next;
            }
        }
        return newHead.next;
    }
}
