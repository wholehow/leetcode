package design;

import java.util.Stack;

/* ���⣺
 * �ö�ջʵ��һ���������в����Ķ��С�
 * 1.push(x)����pushһ��Ԫ��x������β����
 * 2.pop()�����Ӷ���ͷ���Ƴ�һ��Ԫ�ء�
 * 3.peek()������ȡ����ͷ����Ԫ�ء�
 * 4.empty()�������ض����Ƿ��ǿյġ�
 * 
 * ע�⣺
 * 1.�����ʹ�ñ�׼�Ķ�ջ��������Ҳ����ֻ��push�����ˡ��Ӷ���peek/pop��size�Լ�empty��������Ч�ġ�
 * 2.����������ԣ���ջ���ܲ���ԭ��֧�ֵġ������Ҫͨ��ʹ��list����deque��double-ended queue��ģ��һ����ջ��
 * �ͺ�����ʹ�ñ�׼�Ķ�ջ����һ����
 * 3.����Լ������еĲ���������Ч�ģ����粻���һ���ն��н���pop����peek��������
 * */

public class MyQueue {
	
	/* ʵ�ֵ�ʱ��������������˵����Ҫ��pop��peek������
	 * ������Ҫ����ջ�����Ƴ��¼����Ԫ�ظ�Ϊ�Ƴ���ջ�ײ��ʼ�����Ԫ�أ�Ҫ�ﵽ��������͵�����һ����ջ����ʱ�洢���ݡ�
	 * */
	
	// Initialize your data structure here.
    private Stack<Integer> inStack = new Stack<Integer>();
    private Stack<Integer> outStack = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        int res = outStack.pop();
        while (!outStack.empty()) {
            inStack.push(outStack.pop());
        }
        return res;
    }

    // Get the front element.
    public int peek() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        int res = outStack.peek();
        while (!outStack.empty()) {
            inStack.push(outStack.pop());
        }
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
