package linked_list;

import java.util.Stack;

/* ����һ���������ж����Ƿ��ǻ��ġ�
 * ������O��n����ʱ�临�ӶȺ�O��1���Ŀռ临�Ӷ���ʵ����
 * */

public class Solution234 {
	
	/* ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(N)��������������һ���µ���������ͷ�巨������������ԭ����˳���෴��
	 * Ȼ���ͷ��ʼ�Ƚϣ�ֻҪ��һ��λ�����߲�һ����˵���ⲻ��һ�����ĵ�����
	 * */
	
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
        	return true;
        }
        
        ListNode newHead = head;
        ListNode lastNode = new ListNode(head.val);
        
        // ͷ�巨�����µĵ�����
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
	
	/* ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(1)������������ջ����Ҫ��ջ���ǵ�ǰ�������һ�롣
	 * ʹ�ÿ���������ǣ�����Ǹ�ֻ��һ���ô��������������ٶȱ������������ı�ǵ������������ģ�
	 * ��Ȼ����Ҫ���������������������ż�����ֿ��жϣ�Ҳ�ǿ�fast�������ܵ�����滹���ܹ������жϡ�
	 * �ҵ����ĺ�����ջ��ŵ������Ƚ���������ԣ����м�����ͷһ���������������ֵ�ǲ��Ƕ�һ����һ�����ǻ��ģ������ǡ�
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
        // ��������������Ҫ���⴦��
        if (fast != null){
            slow = slow.next;
        }
        // ���м�����ͷ�ж�
        while (slow != null){
            if (stack.pop().val != slow.val) {
            	return false;
            }
            slow = slow.next;
        }
        return true;
    }*/
}
