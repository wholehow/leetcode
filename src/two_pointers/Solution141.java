package two_pointers;

import java.util.HashSet;

/* ����һ�������ж�����û�лػ���
 * ���ף� ���ܲ��ܲ��ö���Ŀռ��������
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
	
	/* ���ü��ϵ����Կ�������ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(N)
	 * */
	
    /*public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return false;
        }
        //��ʵ֤������ֻ�洢ListNode�Ľ��ֵ�ǲ����Ե�
        //������ʵ�ܼ򵥣���ʹû�л�Ҳ���������ظ����ֵ
        HashSet<ListNode> set = new HashSet<ListNode>();
        set.add(head);
        int cnt = 1;	//���ڼ���
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
	
	/* ˫ָ�뷨������ָ��
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
