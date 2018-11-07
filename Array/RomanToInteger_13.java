/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;

import java.util.HashMap;

/**
 *
 * @author Earl_iu
 */
public class RomanToInteger_13 {
    public static int solution(String s){
        int res = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        for(int i =0;i<s.length();i++){
            if(i==s.length()-1){
                res = res+hm.get(s.charAt(i));
            }else if(hm.get(s.charAt(i)) >= hm.get(s.charAt(i+1))){
                res = res+hm.get(s.charAt(i));
            }else{
                res = res - hm.get(s.charAt(i));
            }
        }
        return res;
        
    }
}
