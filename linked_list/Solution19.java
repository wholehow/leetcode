package linked_list;

/* ɾ��������N�����
 * */

public class Solution19 {
	
	/* ����һ��ʹ��slow��fast����ָ�롣
	 * fast����n��λ�ã�Ȼ��slow��fastһ���ߡ���fast�ߵ�nullʱ��slow�����ߵ�������n��λ�á�
	 * ֱ��slow.next = slow.next.next�������ɾ��
	 * */
	
	/*public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode dmy = new ListNode(0);
	    ListNode slow = dmy, fast = dmy;
	    slow.next = head;
	    
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    slow.next = slow.next.next;
	    return dmy.next;
	}*/
	
	/* �����������μ�����
	 * */
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 1) {
			return head;
		}
		ListNode cur = head;
		// ��n�����������Ƚ�
		while (cur != null) {
			n--;
			cur = cur.next;
		}
		// nΪ0��ζ��Ҫɾ���Ľ�����ͷ���
		if (n == 0) {
			return head.next;
		}
		// nС��0��ζ�����м�ĳ����㣬��Ҫ�ҵ��������ǰ��
		if (n < 0) {
			cur = head;
			while (++n != 0) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}
}
