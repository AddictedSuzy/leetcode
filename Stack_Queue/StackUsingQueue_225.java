/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Earl_iu
 */
public class StackUsingQueue_225 {
    
}

class MyStack {
    Queue<Integer> stack = new LinkedList<Integer>();
    
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {       // 只用一个queue
        stack.add(x);
        int n = stack.size();
        while (n-- > 1)
            stack.add(stack.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return stack.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}