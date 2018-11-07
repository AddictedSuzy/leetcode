/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Stack_Queue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Earl_iu
 */
public class MinStack_155 {
    public static void main(String args[]){
        MinStack ms = new MinStack();
        ms.push(5);
    }
   
}

class MinStack{
    private List<Integer> data;  
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<>(); 
    }
    
    public void push(int x) {       // 当我们发现push的值x比最小值小的时候，我们先push最小值，然后push x，这样在pop的时候，我们也pop两个值，并将最小值改成之前的最小值
        if(x<=min){
            data.add(min);
            min = x;
        }
        data.add(x);
    }
    
    public void pop() {
        if(data.get(data.size()-1) == min){
            data.remove(data.size()-1);
            min = data.remove(data.size()-1);
        }else{
            data.remove(data.size()-1);
        }
    }
    
    public int top() {
        return data.get(data.size()-1);
    }
    
    public int getMin() {
        return min;
    }
}

class MinStack_linked {  // 使用linkedlist的数据结构来储存node的最小值
    class Node{
        int value;
        int min;
        Node next;
        
        Node(int x, int min){
            this.value=x;
            this.min=min;
            next = null;
        }
    }
    Node head;
    public void push(int x) {
        if(null==head){
            head = new Node(x,x);
        }else{
            Node n = new Node(x, Math.min(x,head.min));
            n.next=head;
            head=n;
        }
    }

    public void pop() {
        if(head!=null)
            head =head.next;
    }

    public int top() {
        if(head!=null)
            return head.value;
        return -1;
    }

    public int getMin() {
        if(null!=head)
            return head.min;
        return -1;
    }
}
