/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Iterator;

/**
 *
 * @author Earl_iu
 * 知识点：LinkedList
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }


public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int adder = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
    
        while(l1!=null && l2!=null){
            int s = l1.val + l2.val + adder;
            if(s >=10){
                s = s - 10;
                adder = 1;
            }else{
                adder = 0;
            }
            
            curr.next = new ListNode(s);    
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        boolean flag = true;
        int s = 0;
        while(flag){
            if(l1 != null ){            // 如果出现两个linkNode的长度不一样的情况
                s = l1.val+adder;
                if(s>=10){
                    s = s-10;
                    adder =1;
                }else{
                    adder=0;
                }
                curr.next = new ListNode(s);
                curr = curr.next;
                l1 = l1.next;
            }else if(l2 !=null){
                s = l2.val+adder;
                if(s>=10){
                    s = s-10;
                    adder =1;
                }else{
                    adder=0;
                }
                curr.next = new ListNode(s);
                curr = curr.next;
                l2 = l2.next;
            }else{
                flag = false;
            }
        }
        
         if(adder==1){      // 两边的最后一位加完以后，还有余数出来，需要进一位
            curr.next = new ListNode(1);
        }
        return head.next;
    }
     
}
