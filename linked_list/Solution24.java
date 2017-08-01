package linked_list;

/* 给定一个链表，交换每两个相邻的节点并返回其头。
 * 你的算法应该只使用恒定空间。你不能修改列表中的值，只能改变节点本身。
 * */

public class Solution24 {
	
	/* 题目要求O(1)空间复杂度，因此不能使用递归；不能改变列表中的值，意味着单纯的交换相邻两个结点的val是不被允许的。
	 * 对于1-2-3-4，这样的链表，最后需要得到2-1-4-3。为了交换1和2，需要保存1的前序和2的后继。需要两个结点。
	 * 为了得到新的头结点需要使用第三个结点。为了方便找到3，需要第四个结点。为了判断当前走到的位置，需要第五个结点。
	 * 因此共申请5个新的结点值。虽然申请的多，但是逻辑会非常清晰。
	 * */
	
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dmy = new ListNode(0), pre = dmy;
        dmy.next = head;
        // pre.next和pre.next.next是真正需要交换的两个结点
        while (pre.next != null && pre.next.next != null) {
        	// cur=当前，suc=后继，tmp=后继的后继
        	ListNode cur = pre.next, suc = cur.next, tmp = suc.next;
        	pre.next = suc;
        	suc.next = cur;
        	cur.next = tmp;
        	pre = cur;
        }
        return dmy.next;
    }
}
