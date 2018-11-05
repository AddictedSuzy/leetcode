/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author Earl_iu
 * 最长回文子串，回文就是正过来反过来都是同一个单词
 * 动态规划
 *  在i和j相等的时候，可能出现两种情况，即最长回文字串的长度是奇数还是偶数，如果是偶数，那么在一开头的时候s[i]=s[i+1]   
 */
public class PalindromicSubstring_5 {
    public static void main(String agrs[]){
        String s = "bababa";
        System.out.println(DPsearch(s));
    }
    
    public static String DPsearch(String s){
        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int i = n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<2 || dp[i+1][j-1]);
                if(dp[i][j] && (res ==null || j-i+1>res.length())){
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
    
    int maxLen;
    int lo;
    
    public String search_recursion(String s){
        if(s.length()<2){
            return s;
        }
        for(int i =0;i<s.length()-1;i++){
            search(s,i,i);  // 将String长度认为是奇数
            search(s,i,i+1);  // 将String长度认为是偶数
        }
        
        return s.substring(lo,lo+maxLen);
    }
    
    public void search(String s, int j, int k){
        while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(maxLen<k-j+1){
            lo =j+1;
            maxLen = k-j+1;
        }
    }
}
