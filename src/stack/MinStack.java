package stack;

import java.util.Stack;

/* ���⣺
 * ���һ��ջ��֧��push��pop��top�Լ��ڹ̶�ʱ���ڼ�����СԪ�ء�
 * 1.push(x) -- ��Ԫ��x����ջ�С�
 * 2.pop() -- ��ջ�Ķ����Ƴ�Ԫ�ء�
 * 3.top() -- ��ȡջ��Ԫ�ء�
 * 4.getMin() -- ����ջ�е���СԪ�ء�
 * */

public class MinStack {
	
	/* ����ջʱ����Ĳ���ʵ�ʵ�Ԫ��ֵ�������뵱ǰ��¼����Сֵ�Ĳ�ֵ��
	 * �������ĸ�С���ͽ�����Ϊ��Сֵ����ʱ�ͱ�֤����ʱ���Ի�ȡ��Сֵ��
	 * ��ջʱ��Ҫ�޸���Сֵ��
	 * ��ȡջ��Ԫ��ʱ����Ϊջ�м�¼�Ĳ�����ԭʼֵ������Ҫ���¼����Сֵ���в�������ԭ��
	 * ������Ŀ��submitʱ���ó���int��Χ�Ĵ��������ԣ�����ֻ����long��������
	 * */
	
	Stack<Long> stack;
    long min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Long>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min) min = x;
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
        	return;
        }
        long pop = stack.pop();
        if (pop < 0) {
        	min = min - pop;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if (top < 0) {
        	return (int)min;
        } else {
        	return (int)(min + top);
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
