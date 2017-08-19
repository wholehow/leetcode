package linked_list;

import java.util.Stack;

/* ���⣺
 * дһ��������Ѱ������������ʼ����Ľڵ㡣
 * ע�⣺
 * 1.�������������ȫ�����㣬���� null��
 * 2.�������غ�ԭ������뱣�ֳ�ʼ�ṹ��
 * 3.����Լ�����������ṹ��û���κ�ѭ����
 * 4.��Ĵ���Ӧ����O(n)��ʱ���O(1)���ڴ�����ɡ�
 * */

public class Solution160 {
	
	/* ��Ŀ���ѵ�������O(n)��ʱ�������������飬��ô��ͨ�ر���ȥ�ȶԾͲ������ˣ���Ϊ��ȫ��֪����������ĸ��ڵ㿪ʼ���㣬
	 * ��������ڵ������������е�λ��Ҳ��һ����һ����
	 * */
	
	/* ��дһ�ַ�O(1)��д��������ջ�����ȳ������ʡ�
	 * ������������㣬��ô�Ӻ���ǰ�����ǽ���ĵط�������ͬ�ġ�
	 * */
	
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) {
    		return null;
    	}
        boolean hasFind = false;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        Stack<ListNode> stackA = new Stack<ListNode>();
        Stack<ListNode> stackB = new Stack<ListNode>();
        
        // ��headA��headB����ջ
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }
       
        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                result = stackA.peek();
                stackA.pop();
                stackB.pop();
            } else {
                return result;
            }
        }
        return result;
    }*/
	
	/* ��дһ��O(1)�Ľⷨ��Ҳ��˫ָ�뷨��
	 * �������������ĵط�������ѭ��������ݣ�ÿ��ѭ��������������ı�������ƶ�һ�������ƶ���ĩβ���������һ������ͷ���ƶ���ѭ���Ľ������������������ͬ��
	 * ʲô����»���ͬ�أ����������һ����������ͬ�ڵ㣬��һ������ȫû����ͬ�ڵ㡣
	 * ���ڶ������һ�������������Ի���ͬʱ����null��
	 * �������������һֱ����ô��������ֱ�ӱ���һ��û�н���Ͷ�ͬʱ��null�ˡ�����н���ģ���һ���ǵ�һ������㡣
	 * */
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while (nodeA != nodeB) {
        	nodeA = nodeA == null ? headB : nodeA.next;
        	nodeB = nodeB == null ? headA : nodeB.next;
        }
        
        return nodeA;
	}
}
