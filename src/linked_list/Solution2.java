package linked_list;

/* ���������ǿյ�������ʾ�����Ǹ��������������෴��˳��洢��ÿ���ڵ����һ�����֡�����������ֲ�������Ϊ�����ء�
 * ���磺
 * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * �����7 -> 0 -> 8
 * */

public class Solution2 {
	
	/* ����˵�ĵ�����˵�����headָ��ļ��Ǽ����ĵ�λ��Ҳ����˵����û�б�Ҫ�ֶ���������ֱ�Ӱ��ո�����˳����Ӽ��ɡ�
	 * */
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if (l1 == null) return l2;
       if (l2 == null) return l1;
       ListNode cur1 = l1, cur2 = l2;
       int sum = 0;
       ListNode dmy = new ListNode(0), node = dmy;
       // ����l1��l2�ĳ��ȹ�ϵ���迼�ǣ�ֻҪ������Ӽ���
       while (cur1 != null || cur2 != null) {
    	   // ��һλ�Ľ�λ����Ϊ��ǰλ��һ������
    	   sum /= 10;
    	   if (cur1 != null) {
    		   sum += cur1.val;
    		   cur1 = cur1.next;
    	   }
    	   if (cur2 != null) {
    		   sum += cur2.val;
    		   cur2 = cur2.next;
    	   }
    	   // ȡ����Ϊ��ǰλ����
    	   node.next = new ListNode(sum % 10);
    	   node = node.next;
       }
       // �������������󻹴��ڽ�λ
       if (sum /10 == 1) {
    	   node.next = new ListNode(1);
       }
       return dmy.next;
    }
}
