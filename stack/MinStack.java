package stack;

import java.util.Stack;

/* 大意：
 * 设计一个栈，支持push、pop、top以及在固定时间内检索最小元素。
 * 1.push(x) -- 将元素x放入栈中。
 * 2.pop() -- 从栈的顶端移除元素。
 * 3.top() -- 获取栈顶元素。
 * 4.getMin() -- 检索栈中的最小元素。
 * */

public class MinStack {
	
	/* 在入栈时，入的不是实际的元素值，而是与当前记录的最小值的差值，
	 * 如果新入的更小，就将其设为最小值，此时就保证了随时可以获取最小值。
	 * 出栈时，要修改最小值。
	 * 获取栈顶元素时，因为栈中记录的并不是原始值，所以要与记录的最小值进行操作来还原。
	 * 由于题目在submit时会用超过int范围的大数来测试，所以只能用long来操作。
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
