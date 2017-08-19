package linked_list;

/* 给定两个非空的链表，表示两个非负整数。数字以相反的顺序存储，每个节点包含一个数字。添加两个数字并将其作为链表返回。
 * 例如：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * */

public class Solution2 {
	
	/* 这里说的倒序是说链表的head指向的即是加数的低位，也就是说我们没有必要现对链表逆序，直接按照给出的顺序相加即可。
	 * */
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if (l1 == null) return l2;
       if (l2 == null) return l1;
       ListNode cur1 = l1, cur2 = l2;
       int sum = 0;
       ListNode dmy = new ListNode(0), node = dmy;
       // 这里l1和l2的长度关系无需考虑，只要进行相加即可
       while (cur1 != null || cur2 != null) {
    	   // 上一位的进位数作为当前位的一个加数
    	   sum /= 10;
    	   if (cur1 != null) {
    		   sum += cur1.val;
    		   cur1 = cur1.next;
    	   }
    	   if (cur2 != null) {
    		   sum += cur2.val;
    		   cur2 = cur2.next;
    	   }
    	   // 取余作为当前位的数
    	   node.next = new ListNode(sum % 10);
    	   node = node.next;
       }
       // 单独处理，如果最后还存在进位
       if (sum /10 == 1) {
    	   node.next = new ListNode(1);
       }
       return dmy.next;
    }
}
