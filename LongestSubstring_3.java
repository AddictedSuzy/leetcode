/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Earl_iu
 * Given a string, find the length of the longest substring without repeating characters.
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 */
public class LongestSubstring_3 {
    public static void main(String agrs[]){
        int a = elegantSubstring("ppwwkk");
        System.out.println(a);
    }
    public static int lengthOfLongestSubstring(String s) {      // stupid way
        ArrayList<Character> ch = new ArrayList<Character>();
        int max = 1;
        if(s == null || s.length() <1){
            return 0;
        }else{
            for(int i =0;i<s.length()-max;i++){
                ch.add(s.charAt(i));
                int count = 1;
                for(int j =i+1;j<s.length();j++){
                    if(!ch.contains(s.charAt(j))){
                        ch.add(s.charAt(j));
                        count = count +1;
                        if(count >max){
                            max = count;
                        }
                    }else{
                        ch = new ArrayList<Character>();
                        break;
                    }
                }
            }
        }
       return max;
    }
    
    public static int elegantSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            res = Math.max(res, i - left + 1);
            map.put(c, i);
        }
        return res;
    }
}
