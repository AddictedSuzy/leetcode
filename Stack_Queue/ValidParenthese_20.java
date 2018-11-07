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
 * 用正确的括号表达方式 不能出现"{[}]"这样不正确的表达
 * 用Stack来储存需要的括号，后进的说明在前面括号的内部，所以他们的另一半得先得到，所以用Stack
 */
public class ValidParenthese_20 {
    public static void main(String args[]){
        String s = "[]";
        System.out.println(solution(s));
    }
    
    public static boolean solution(String s){
        Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
    }
}
