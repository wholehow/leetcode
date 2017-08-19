package linked_list;

/* ����һ��������������������������һ��Ȼ����ż����㡣��ע�⣬��������̸�۽��Ŷ����ǽ���е�ֵ��
 * ��Ӧ�þ���������һ�㡣����Ӧ������O(1)�ռ临���Ժ�O(N)ʱ�临�Ӷȡ�
 * ���磺
 * ���룺1->2->3->4->5->NULL
 * �����1->3->5->2->4->NULL
 * ע�⣺
 * 1.ż�����������ڵ����˳��Ӧ��������������ͬ��
 * 2.��һ����㱻��Ϊ���������ڶ�����㱻��Ϊ��ż��㣬�Դ�����...
 * */

public class Solution328 {
	
	/* �ǳ��򵥵�һ����Ŀ��˫ָ�Ʒ���
	 * */
	
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        // Ϊ����������odd��even����ҪevenHead��¼��ʼʱeven��λ��
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
        	odd.next = odd.next.next;
        	even.next = even.next.next;
        	odd = odd.next;
        	even = even.next;
        }
        // odd��even��������
        odd.next = evenHead;
        return head;
    }
}
