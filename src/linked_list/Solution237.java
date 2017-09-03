package linked_list;

/* 大意：
 * 写一个函数来删除一个简单链表中的一个节点（除了尾节点），只给出这个节点。
 * 假设有一个链表 1->2->3->4，并给你第三个值为3的节点，在调用你的函数之后这个链表应该变成1->2->4。
 * */

public class Solution237 {
	
	/* 一般我们删除一个链表节点，直接将其上一个节点的next指向其下一个节点就可以了，
	 * 但是这里只给出了该节点本身，也就是说你只能获取到该节点本身以及其下一个节点。
	 * 那么就只能将该节点直接变成下一个节点了，将其值设为下一个节点的值，将其next指向下一个节点的next，就可以了。
	 * */
	
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
