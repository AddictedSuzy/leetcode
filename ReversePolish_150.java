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
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * 后缀表达式的计算方法：遍历整个表达式，如果为数字则入栈，如果为符号则将前面两个数字出栈，先出栈的在右边后出栈的在左边符号放中间算出来结果再扔到栈中即可。
 */
public class ReversePolish_150 {
    public static void main(String args[]){
        String[] s = {"2", "1", "+", "3", "*"};
        System.out.println(eval(s));
    }
    
    public static int eval(String[] tokens){
        Stack<Integer> s = new Stack<>();
        for(int i =0;i<tokens.length;i++){
            if("*".equals(tokens[i])){
                int a = s.pop();
                int b = s.pop();
                s.push(a*b);
            }else if("+".equals(tokens[i])){
                int a = s.pop();
                int b = s.pop();
                s.push(a+b);
            }else if("-".equals(tokens[i])){
                int a = s.pop();
                int b = s.pop();
                s.push(a-b);
            }else if("/".equals(tokens[i])){
                int a = s.pop();
                int b = s.pop();
                s.push(b/a);
            }else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}
