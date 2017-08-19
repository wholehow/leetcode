package linked_list;

/* ���õ�����
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution206 {
	
	/* �ǳ���������
	 * */
	
	/*����*/
	
	/*public ListNode reverseList(ListNode head) {
	    ListNode newHead = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = newHead;
	        newHead = head;
	        head = next;
	    }
	    return newHead;
	}*/
	
	/*�ݹ�*/
	
	public ListNode reverseList(ListNode head) {
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null) {
	        return newHead;
	    }
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
}
