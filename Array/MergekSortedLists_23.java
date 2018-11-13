/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Earl_iu
 * K个有序的linked list合并
 */
public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {     // 方法1： 归并
        if(lists == null || lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        ListNode l = merge(lists, left, mid);
        ListNode r = merge(lists, mid + 1, right);
        return mergeTwo(l, r);
    }
    private ListNode mergeTwo(ListNode l, ListNode r){
        ListNode fakeHead = new ListNode(0);
        ListNode f = fakeHead, p = l, q = r;
        while(p != null && q != null){
            if(p.val < q.val){
                f.next = p;
                p = p.next;
            }else{
                f.next = q;
                q = q.next;
            }
            f = f.next;
        }
        if(p != null){
            f.next = p;
        }
        if(q != null){
            f.next = q;
        }
        return fakeHead.next;
    }
    
    public ListNode priorty_merge(ListNode[] lists){        // 方法2： 优先队列
        if (lists == null || lists.length < 1) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode n = node;
        PriorityQueue<ListNode> min = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for(int i =0;i<lists.length;i++){
            if(lists[i] !=null){
                min.add(lists[i]);
            }
        }
        
        while(!min.isEmpty()){
            ListNode temp = min.poll();
            n.next = temp;
            n = n.next;
            if(temp.next != null){
                min.add(temp.next);
            }
        }
        return node.next;
    }
}
