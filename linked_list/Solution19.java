package linked_list;

/* 删除倒数第N个结点
 * */

public class Solution19 {
	
	/* 方法一。使用slow和fast两个指针。
	 * fast先走n个位置，然后slow和fast一起走。当fast走到null时，slow正好走到倒数第n个位置。
	 * 直接slow.next = slow.next.next即可完成删除
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
	
	/* 方法二。两次计数。
	 * */
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 1) {
			return head;
		}
		ListNode cur = head;
		// 将n与链表长度作比较
		while (cur != null) {
			n--;
			cur = cur.next;
		}
		// n为0意味着要删除的结点就是头结点
		if (n == 0) {
			return head.next;
		}
		// n小于0意味着是中间某个结点，需要找到这个结点的前序
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
