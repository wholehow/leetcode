package linked_list;

import java.util.Stack;

/* ���������ǿյ�������ʾ�����Ǹ�����������Ҫ�������ǵ�һ����ÿ���ڵ����һ�����֡�����������ֲ�������Ϊ�����ء�
 * ����Լ����������ֲ������κ�ǰ���㣬��������0����
 * ����㲻���޸������б���ô�죿���仰˵����ת�б��ǲ�����ġ�
 * ���磺
 * ���룺(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * �����7 -> 8 -> 0 -> 7
 * */

public class Solution445 {
	
	/* ����Ŀ2�������ǣ���Ŀ2������445������
	 * ��Ȼ������ת�����������ת����ֱ������2�Ľⷨ������ô�ܹ����ٰ�������ʵ������ľ���Stack�ˡ�
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
        	// ��ǰλ
        	newHead.val = sum % 10;
        	// ��λλ
        	ListNode node = new ListNode(sum / 10);
        	node.next = newHead;
        	newHead = node;
        	sum /= 10;
        }
        return newHead.val == 0 ? newHead.next : newHead;
    }
}
