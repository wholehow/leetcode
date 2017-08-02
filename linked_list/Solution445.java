package linked_list;

import java.util.Stack;

/* 给定两个非空的链表，表示两个非负整数。最重要的数字是第一个，每个节点包含一个数字。添加两个数字并将其作为链表返回。
 * 你可以假设两个数字不包含任何前导零，除了数字0本身。
 * 如果你不能修改输入列表怎么办？换句话说，反转列表是不允许的。
 * 例如：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * */

public class Solution445 {
	
	/* 和题目2的区别是，题目2是正序，445是逆序。
	 * 既然不允许反转链表（如果允许反转链表直接运用2的解法），那么能够快速帮助我们实现逆序的就是Stack了。
	 * */
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1 != null) {
        	stack1.push(l1.val);
        	l1 = l1.next;
        }
        while (l2 != null) {
        	stack2.push(l2.val);
        	l2 = l2.next;
        }
        ListNode newHead = new ListNode(0);
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
        	if (!stack1.isEmpty()) {
        		sum += stack1.pop();
        	}
        	if (!stack2.isEmpty()) {
        		sum += stack2.pop();
        	}
        	// 当前位
        	newHead.val = sum % 10;
        	// 进位位
        	ListNode node = new ListNode(sum / 10);
        	node.next = newHead;
        	newHead = node;
        	sum /= 10;
        }
        return newHead.val == 0 ? newHead.next : newHead;
    }
}
