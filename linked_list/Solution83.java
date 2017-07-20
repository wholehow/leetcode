package linked_list;

/* 大意：
 * 给出一个排好序的链表，删除所有的重复的数字，让每个元素只出现一次。 
 * 比如： 给出 1->1->2, 返回1->2. 
 * 给出1->1->2->3->3, 返回1->2->3.
 * */

public class Solution83 {
	
	/* 1.首先是首节点为空的情况要考虑；
	 * 2.其次是只有当当前数字和下一个数字不一样时才把操作的节点换成下一个节点去继续向后操作，因为有可能有多个重复的数字串在一起，
	 * 不能删除一个节点后就直接往后移进行判断，要判断删了一个以后下一个是否还是一样；
	 * 3.如果链表的最后几个数字都是重复的，我们在检测到重复的数字时会删除它然后将当前节点的next指向next的next，
	 * 但是这里要注意判断next是否还有next，如果没有却进行操作，那就会出错了。
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
