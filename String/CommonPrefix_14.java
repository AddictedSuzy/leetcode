/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.String;

/**
 *
 * @author Earl_iu
 * 最长公公前缀
 */
public class CommonPrefix_14 {
    public static void main(String agrs[]){
        String[] s = {"aaa","aa","aaa"};
        System.out.println(solution(s));
    }
    public static String solution(String[] s){
        if(s.length ==0){
            return "";
        }
        String pre = s[0];
        for(int i =1;i<s.length;i++){
            while(s[i].indexOf(pre) !=0){
                pre = pre.substring(0,pre.length()-1);
                if(pre.isEmpty()){
                    return "";
                }
            }
        }
        return pre;
    }
}
