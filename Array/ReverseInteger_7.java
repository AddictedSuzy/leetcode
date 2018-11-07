/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;


/**
 *
 * @author Earl_iu
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 *  Input: 123
 *  Output: 321
 */
public class ReverseInteger_7 {
    public static void main(String agrs[]){
        int result = reverse(100);
        System.out.println(result);
    }
    
    /*
        不断地做原来的结果*10+tail就可以得到reverse的值
        例如51，tail = 1; result = 0*10+1; tail = 5; result = result *10+5;
    */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}

