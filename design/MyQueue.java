package design;

import java.util.Stack;

/* 大意：
 * 用堆栈实现一个满足下列操作的队列。
 * 1.push(x)——push一个元素x到队列尾部。
 * 2.pop()——从队列头部移除一个元素。
 * 3.peek()——获取队列头部的元素。
 * 4.empty()——返回队列是否是空的。
 * 
 * 注意：
 * 1.你必须使用标准的堆栈操作——也就是只有push到顶端、从顶端peek/pop、size以及empty操作是有效的。
 * 2.根据你的语言，堆栈可能不是原生支持的。你可能要通过使用list或者deque（double-ended queue）模仿一个堆栈，
 * 就好像在使用标准的堆栈操作一样。
 * 3.你可以假设所有的操作都是有效的（比如不会对一个空队列进行pop或者peek操作）。
 * */

public class MyQueue {
	
	/* 实现的时候，其他操作都好说，主要是pop和peek操作，
	 * 我们需要将堆栈本身移除新加入的元素改为移除堆栈底部最开始加入的元素，要达到这个操作就得用另一个堆栈来临时存储数据。
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
