package linked_list;

import java.util.Stack;

/* 大意：
 * 写一个函数来寻找两个单链表开始交汇的节点。
 * 注意：
 * 1.如果两个链表完全不交汇，返回 null。
 * 2.函数返回后原链表必须保持初始结构。
 * 3.你可以假设整个链表结构都没有任何循环。
 * 4.你的代码应该在O(n)的时间和O(1)的内存中完成。
 * */

public class Solution160 {
	
	/* 题目的难点在于在O(n)的时间内完成这个事情，那么普通地遍历去比对就不合适了，因为完全不知道链表会在哪个节点开始交汇，
	 * 而且这个节点在两个链表中的位置也不一定是一样的
	 * */
	
	/* 先写一种非O(1)的写法，利用栈后入先出的性质。
	 * 如果两个链表交汇，那么从后往前看它们交汇的地方都是相同的。
	 * */
	
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) {
    		return null;
    	}
        boolean hasFind = false;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        Stack<ListNode> stackA = new Stack<ListNode>();
        Stack<ListNode> stackB = new Stack<ListNode>();
        
        // 将headA和headB都入栈
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }
       
        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                result = stackA.peek();
                stackA.pop();
                stackB.pop();
            } else {
                return result;
            }
        }
        return result;
    }*/
	
	/* 再写一种O(1)的解法，也是双指针法。
	 * 这个做法很巧妙的地方在于其循环体的内容，每轮循环都将两个链表的标记往后移动一个，当移动到末尾后就跳到另一个链表头再移动，循环的结束条件是两个标记相同。
	 * 什么情况下会相同呢？两种情况，一是遇到了相同节点，另一个是完全没有相同节点。
	 * 由于都会遍历一次两个链表，所以会在同时到达null。
	 * 如果两个链表长度一直，那么不用跳，直接遍历一次没有交汇就都同时到null了。如果有交汇的，那一定是第一个交汇点。
	 * */
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while (nodeA != nodeB) {
        	nodeA = nodeA == null ? headB : nodeA.next;
        	nodeB = nodeB == null ? headA : nodeB.next;
        }
        
        return nodeA;
	}
}
