/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Stack;

/**
 *
 * @author Earl_iu
 *  Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 */
public class DailyTemperatures_739 {
    public static int[] daily_reverse(int[] T){
        if(T == null || T.length ==0){
            return T;
        }
        int[] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i =T.length-1;i>=0;i++){        // 我们在stack的top上的值一直是一个最大的值，如果我们在循环中一个值比它还大，那么就将他pop，
            result[i] = 0;                                    //  将大的值push in，因为没有必要储存这个值了，前面的值再找比大的值的时候，不会循环到该值就结束
            while(!st.isEmpty()&& T[i]>=T[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i] = 0;
            }else{
                result[i] = st.peek() -i;
            }
            st.push(i);
        }
        return result;
    }
    
    public int[] daily(int[] T) {
        
        int length = T.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < length; i++){
            
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int idx = stack.pop();
                result[idx] = i - idx;
            }
                                               
            stack.push(i);
        }
        return result;
        
    }
}
