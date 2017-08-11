package sort;

import linked_list.ListNode;

/* ʹ�ú㶨�ռ临�Ӷ���O(nlogn)ʱ���ڶ������������
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
	
	/* ������ĿҪ���ܹ���O(1)�ռ临�Ӷȡ�O(nlogn)ʱ�临�Ӷ��ڶ�����������򣬿���ֻ�й鲢�����ˡ�
	 * ��������ƿռ�Ļ�ʹ�������з������ġ�
	 * */
	
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode pre = null, slow = head, fast = head;
        // ���̽���ʱ��slow���Ұ����ĵ�һ����㣬fast���Ұ��������һ�����
        while (fast != null && fast.next != null) {
        	pre = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        // ����
        pre.next = null;
        // �ݹ���ã�������󻮷�Ϊһ���������Ľ�㣬Ȼ������merge�������кϲ�
        ListNode left = sortList(head), right = sortList(slow);
        return merge(left, right);
    }
    // �ܼ򵥵�����ϲ�����
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
