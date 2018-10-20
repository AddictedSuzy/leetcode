/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Earl_iu
 * Given a linked list, determine if it has a cycle in it.
 * 方法1：
 *      使用的方法是将去过的node都放进hashset中，每到一个新的节点就检查该节点是否在hashset中
 * 方法2：
 *      我们设置n，m来追踪结点，n为m.next.next，如果cycle的话，总会有一次n=m，如果在n到达重点前，n和m还没有重合一次的话，那么该linkedlist就没有cycle
 */

public class LinkedListhasCycle_141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
} 
