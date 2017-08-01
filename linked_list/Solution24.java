package linked_list;

/* ����һ����������ÿ�������ڵĽڵ㲢������ͷ��
 * ����㷨Ӧ��ֻʹ�ú㶨�ռ䡣�㲻���޸��б��е�ֵ��ֻ�ܸı�ڵ㱾��
 * */

public class Solution24 {
	
	/* ��ĿҪ��O(1)�ռ临�Ӷȣ���˲���ʹ�õݹ飻���ܸı��б��е�ֵ����ζ�ŵ����Ľ���������������val�ǲ�������ġ�
	 * ����1-2-3-4�����������������Ҫ�õ�2-1-4-3��Ϊ�˽���1��2����Ҫ����1��ǰ���2�ĺ�̡���Ҫ������㡣
	 * Ϊ�˵õ��µ�ͷ�����Ҫʹ�õ�������㡣Ϊ�˷����ҵ�3����Ҫ���ĸ���㡣Ϊ���жϵ�ǰ�ߵ���λ�ã���Ҫ�������㡣
	 * ��˹�����5���µĽ��ֵ����Ȼ����Ķ࣬�����߼���ǳ�������
	 * */
	
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dmy = new ListNode(0), pre = dmy;
        dmy.next = head;
        // pre.next��pre.next.next��������Ҫ�������������
        while (pre.next != null && pre.next.next != null) {
        	// cur=��ǰ��suc=��̣�tmp=��̵ĺ��
        	ListNode cur = pre.next, suc = cur.next, tmp = suc.next;
        	pre.next = suc;
        	suc.next = cur;
        	cur.next = tmp;
        	pre = cur;
        }
        return dmy.next;
    }
}
