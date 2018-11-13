/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.String;

/**
 *
 * @author Earl_iu
 */
public class StringtoInteger_8 {
    public static void main(String args[]){
        String s = "-123123123123123123";
        System.out.println(myAtoi(s));
        int x = -912834723;
    }
    public static int myAtoi(String str) {
        str = str.trim();
        int num = 0;
        int sign = 1;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i) == '-' && i ==0){
                sign = -1;
            }else if(str.charAt(i) == '+' && i ==0){
                sign = 1;
            }else{
                if(Character.isDigit(str.charAt(i))){
                    if(num>Integer.MAX_VALUE/10 ||  (num == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < Character.getNumericValue(str.charAt(i)))){
                        return sign ==1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
                    }
                    num = num*10+Character.getNumericValue(str.charAt(i));
                }else{
                    break;
                }
            }
        }
        num = num * sign;
        return num;
    }
}
