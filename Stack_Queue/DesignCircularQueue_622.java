/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Stack_Queue;

import java.util.ArrayList;

/**
 *
 * @author Earl_iu
 * 循环队列
 * Design your implementation of the circular queue. 
 * The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. 
 * It is also called "Ring Buffer".
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. 
 * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. 
 * But using the circular queue, we can use the space to store new values.
 * 
 * Your implementation should support following operations:
 *   MyCircularQueue(k): Constructor, set the size of the queue to be k.
 *   Front: Get the front item from the queue. If the queue is empty, return -1.
 *   Rear: Get the last item from the queue. If the queue is empty, return -1.
 *   enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 *   deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 *   isEmpty(): Checks whether the circular queue is empty or not.   
 *   isFull(): Checks whether the circular queue is full or not.
 */

public class DesignCircularQueue_622 {
    public static void main(String args[]){
        MyCircularQueue mq = new MyCircularQueue(5);
        boolean param_1 = mq.enQueue(5);
        boolean param_2 = mq.deQueue();
        int param_3 = mq.Front();
        int param_4 = mq.Rear();
    }
}

class MyCircularQueue{
    int[] queue;
    int start = 0;
    int end = -1; 
    int len = 0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            end = (end+1) % queue.length;
            queue[end] = value;
            len++;
            return true;
        }else{
            return false;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            start = (start+1) % queue.length;
            len--;
            return true;
        }else{
            return false;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()){
            int front = queue[start];
            return front;
        }else{
            return -1;
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return(isEmpty() ? -1:queue[end]);
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return len==0;   
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return len==queue.length;
    }
}
