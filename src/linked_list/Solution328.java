package linked_list;

/* 给定一个单链表，将所有奇数结点组合在一起，然后是偶数结点。请注意，我们正在谈论结点号而不是结点中的值。
 * 你应该尽量做到这一点。程序应运行在O(1)空间复杂性和O(N)时间复杂度。
 * 例如：
 * 输入：1->2->3->4->5->NULL
 * 输出：1->3->5->2->4->NULL
 * 注意：
 * 1.偶数和奇数组内的相对顺序应保持与输入中相同。
 * 2.第一个结点被认为是奇数，第二个结点被认为是偶结点，以此类推...
 * */

public class Solution328 {
	
	/* 非常简单的一道题目。双指纹法。
	 * */
	
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        // 为了重新链接odd和even，需要evenHead记录开始时even的位置
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
        	odd.next = odd.next.next;
        	even.next = even.next.next;
        	odd = odd.next;
        	even = even.next;
        }
        // odd和even重新链接
        odd.next = evenHead;
        return head;
    }
}
