package design;

import java.util.LinkedList;
import java.util.Queue;

/* ���⣺
 * ʹ�ö���ʵ�������ջ������
 * 1.push��x��--��Ԫ��xpush��ջ��ȥ��
 * 2.pop����--�Ƴ�ջ����Ԫ�ء�
 * 3.top����--��ȡջ����Ԫ�ء�
 * 4.empty����--����ջ�Ƿ�Ϊ�ա�
 * 
 * ע�⣺
 * 1.��ֻ��ʹ�ö��еı�׼��������Ҳ����ֻ��push����β���Ӷ���peek/pop��size���Ƿ�Ϊempty��������Ч�ġ�
 * 2.����������ԣ����п��ܲ���ԭ��֧�ֵġ������ʹ��list����deque��˫β���У�ģ��һ�����У�ֻҪ��ֻʹ�ö��еı�׼������
 * 3.����Լ������еĲ���������Ч�ģ����磬����pop����topһ����ջ����
 * */

public class MyStack {
	
	/* ��ʵ�ö���ʵ��ջ�޷Ǿ���һ������˳��һ����ջ�Ǻ���ȳ����������Ƚ��ȳ���
	 * ���Ҫô�ı���г���������ȫ������ֱ�����һ��������Ϊջ��Ҫ���ģ�
	 * Ҫô����ӵ�������ÿ�����ʱ��ȫ��ȡ����һ�飬����Ԫ�����ڶ���ȥ����������ʱ����ǵ�һ�������ˡ�
	 * */
	
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> tmp = new LinkedList<Integer>();
        while (queue.peek() != null) {
            tmp.add(queue.poll());
        }
        queue.add(x);
        while (tmp.peek() != null) {
            queue.add(tmp.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.peek() == null;
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */	