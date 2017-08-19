package linked_list;

/* 旋转链表
 * 给定链表，将列表向右旋转k个位置，其中k是非负数。
 * 例如：
 * 输入：1->2->3->4->5->NULL， k = 2
 * 输出：4->5->1->2->3->NULL
 * */

public class Solution61 {
	
	/* 这里给出的k其实是将前i-k%i的链表向后移动k个位置，其中i为链表的长度。
	 * 因为k的长度可能大于i所以这里要用取余操作。
	 * 基本思想就是：
	 * 1.用fast辅助记录链表的长度
	 * 2.用slow辅助记录链表需要后移的部分的结尾
	 * 3.用dmy保存新的头结点
	 * 4.因为需要移动的部分不需要反转，那么我们直接将fast.next指向slow.next，slow.next置空，即可
	 * */
	
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        ListNode fast = dmy, slow = dmy;
        int i = 0;
        for (; fast.next != null; i++) {
        	fast = fast.next;
        }
        for (int j = i - k % i; j > 0; j--) {
        	slow = slow.next;
        }
        fast.next = dmy.next;
        dmy.next = slow.next;
        slow.next = null;
        return dmy.next;
    }
}
