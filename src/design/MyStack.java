package design;

import java.util.LinkedList;
import java.util.Queue;

/* 大意：
 * 使用队列实现下面的栈操作：
 * 1.push（x）--将元素xpush到栈中去。
 * 2.pop（）--移除栈顶的元素。
 * 3.top（）--获取栈顶的元素。
 * 4.empty（）--返回栈是否为空。
 * 
 * 注意：
 * 1.你只能使用队列的标准操作——也就是只有push到队尾、从队首peek/pop、size和是否为empty操作是有效的。
 * 2.根据你的语言，队列可能不是原生支持的。你可以使用list或者deque（双尾队列）模仿一个队列，只要你只使用队列的标准操作。
 * 3.你可以假设所有的操作都是有效的（比如，不会pop或者top一个空栈）。
 * */

public class MyStack {
	
	/* 其实用队列实现栈无非就是一个出的顺序不一样，栈是后进先出，队列是先进先出，
	 * 因此要么改变队列出的做法，全部出完直到最后一个才是作为栈需要出的；
	 * 要么改入队的做法，每次入的时候都全部取出来一遍，将新元素入在队首去，这样出的时候就是第一个出的了。
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