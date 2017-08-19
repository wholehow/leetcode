package linked_list;

/* 大意：
 * 移除链表中素有值为val的元素。
 * 例如：
 * 给出: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 
 * 返回: 1 --> 2 --> 3 --> 4 --> 5
 * */

public class Solution203 {
	
	/* 遍历链表遇到值跟val相同的就删除节点就好
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
