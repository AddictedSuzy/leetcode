/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Stack_Queue;

import java.util.Stack;

/**
 *
 * @author Earl_iu
 * 
 */

class MyQueue {

    /** Initialize your data structure here. */
     Stack<Integer> queue = new Stack<Integer>();
    
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();  // 使用两个stack
        while(!queue.empty()){
            temp.push(queue.pop());
        }
        queue.push(x);
        while(!temp.empty()){
            queue.push(temp.pop());
        }   
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
         return queue.empty();
    }
}
