package two_pointers;

import java.util.HashSet;

/* 给出一个链表，判断它有没有回环。
 * 进阶： 你能不能不用额外的空间来解决？
 * */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
public class Solution141 {
	
	/* 利用集合的特性可以做到时间复杂度为O(N)，空间复杂度为O(N)
	 * */
	
    /*public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return false;
        }
        //事实证明这里只存储ListNode的结点值是不可以的
        //道理其实很简单，即使没有环也不代表不能重复结点值
        HashSet<ListNode> set = new HashSet<ListNode>();
        set.add(head);
        int cnt = 1;	//用于计数
        while (head.next != null) {
        	set.add(head.next);
        	cnt++;
        	if (cnt > set.size()) {
        		return true;
        	}
        	head = head.next;
        }
        return false;
    }*/
	
	/* 双指针法，快慢指针
	 * */
	
    public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if (fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        } 
        return true;
    }
}
