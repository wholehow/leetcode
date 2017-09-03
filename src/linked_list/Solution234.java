package linked_list;

import java.util.Stack;

/* 给出一个单链表，判断它是否是回文。
 * 你能在O（n）的时间复杂度和O（1）的空间复杂度下实现吗？
 * */

public class Solution234 {
	
	/* 时间复杂度O(N)，空间复杂度O(N)的做法就是申请一个新的链表，采用头插法构造的新链表和原链表顺序相反。
	 * 然后从头开始比较，只要有一个位置两者不一样就说明这不是一个回文单链表。
	 * */
	
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
        	return true;
        }
        
        ListNode newHead = head;
        ListNode lastNode = new ListNode(head.val);
        
        // 头插法构造新的单链表
        while (newHead.next != null) {
            newHead = newHead.next;
            ListNode newNode = new ListNode(newHead.val);
            newNode.next = lastNode;
            lastNode = newNode;
        }
        
        if (head.val != lastNode.val) {
        	return false;
        }
        while (head.next != null) {
            head = head.next;
            lastNode = lastNode.next;
            if (head.val != lastNode.val) {
            	return false;
            }
        }
        
        return true;
    }
	
	/* 时间复杂度O(N)，空间复杂度O(1)的做法是利用栈，需要入栈的是当前单链表的一半。
	 * 使用快慢两个标记，快的那个只有一个用处，就是以两倍速度遍历，引导慢的标记到达链表最中心，
	 * 当然这里要根据链表个数是奇数还是偶数来分开判断，也是看fast是正好跑到最后面还是跑过了来判断。
	 * 找到中心后，利用栈存放的数据先进后出的特性，从中间往两头一起遍历，看遍历的值是不是都一样，一样则是回文，否则不是。
	 * */
	
    /*public boolean isPalindrome(ListNode head) {
        ListNode fast = head; 
        ListNode slow = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            fast = fast.next.next;
            slow = slow.next;
        }
        // 对于奇数链表需要特殊处理
        if (fast != null){
            slow = slow.next;
        }
        // 从中间往两头判断
        while (slow != null){
            if (stack.pop().val != slow.val) {
            	return false;
            }
            slow = slow.next;
        }
        return true;
    }*/
}
