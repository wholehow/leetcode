package linked_list;

/* 合并两个有序单链表
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution21 {
	
	/* 这是严版《数据结构》例题
	 * */
	
	/* 递归法 */
    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
        	return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
        	l1.next = mergeTwoLists(l1.next, l2);
        	return l1;
        } else {
        	l2.next = mergeTwoLists(l1, l2.next);
        	return l2;
        }
    }*/
    
    /* 非递归法 */
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
        	return l1 == null ? l2 : l1;
        }
        ListNode list;
        ListNode listTmp;
        
        if (l1.val <= l2.val) {
        	list = l1;
            l1 = l1.next;
        } else {
        	list = l2;
            l2 = l2.next;
        }
        listTmp = list;
        
        while (l1 != null) {
            if (l2 != null && l2.val < l1.val) {
            	listTmp.next = l2;
            	listTmp = listTmp.next;
                l2 = l2.next;
            } else {
            	listTmp.next = l1;
            	listTmp = listTmp.next;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
        	listTmp.next = l2;
        }
        return list;
    }
}
