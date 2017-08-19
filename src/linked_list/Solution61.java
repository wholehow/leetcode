package linked_list;

/* ��ת����
 * �����������б�������תk��λ�ã�����k�ǷǸ�����
 * ���磺
 * ���룺1->2->3->4->5->NULL�� k = 2
 * �����4->5->1->2->3->NULL
 * */

public class Solution61 {
	
	/* ���������k��ʵ�ǽ�ǰi-k%i����������ƶ�k��λ�ã�����iΪ����ĳ��ȡ�
	 * ��Ϊk�ĳ��ȿ��ܴ���i��������Ҫ��ȡ�������
	 * ����˼����ǣ�
	 * 1.��fast������¼����ĳ���
	 * 2.��slow������¼������Ҫ���ƵĲ��ֵĽ�β
	 * 3.��dmy�����µ�ͷ���
	 * 4.��Ϊ��Ҫ�ƶ��Ĳ��ֲ���Ҫ��ת����ô����ֱ�ӽ�fast.nextָ��slow.next��slow.next�ÿգ�����
	 * */
	
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        ListNode fast = dmy, slow = dmy;
        int i = 0;
        for (; fast.next != null; i++) {
        	fast = fast.next;
        }
        for (int j = i - k % i; j > 0; j--) {
        	slow = slow.next;
        }
        fast.next = dmy.next;
        dmy.next = slow.next;
        slow.next = null;
        return dmy.next;
    }
}
