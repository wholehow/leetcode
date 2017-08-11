package sort;

import linked_list.ListNode;

/* 使用恒定空间复杂度在O(nlogn)时间内对链表进行排序。
 * */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution148 {
	
	/* 根绝题目要求，能够在O(1)空间复杂度、O(nlogn)时间复杂度内对链表进行排序，恐怕只有归并排序了。
	 * 如果不限制空间的话使用三向切分是最快的。
	 * */
	
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode pre = null, slow = head, fast = head;
        // 过程结束时，slow是右半区的第一个结点，fast是右半区的最后一个结点
        while (fast != null && fast.next != null) {
        	pre = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        // 二分
        pre.next = null;
        // 递归调用，链表最后划分为一个个单独的结点，然后利用merge方法进行合并
        ListNode left = sortList(head), right = sortList(slow);
        return merge(left, right);
    }
    // 很简单的链表合并方法
    private ListNode merge(ListNode l1, ListNode l2) {
    	ListNode dmy = new ListNode(0), pre = dmy;
    	while (l1 != null && l2 != null) {
    		if (l1.val <= l2.val) {
    			pre.next = l1;
    			l1 = l1.next;
    		} else {
    			pre.next = l2;
    			l2 = l2.next;
    		}
    		pre = pre.next;
    	}
    	if (l1 != null) {
    		pre.next = l1;
    	}
    	if (l2 != null) {
    		pre.next = l2;
    	}
    	return dmy.next;
    }
}
