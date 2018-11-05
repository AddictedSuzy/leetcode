/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author Earl_iu
 * 用最少的数量的平方数（1,4,9,16...）来构成给定的数
 * input: 12
 * output: 3 (4+4+4)
 */
public class PerfectSquares_279 {
    public static void main(String args[]){
        System.out.println(solution(33));
    }
    public static int solution(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i =0;i<=n;i++){
            for(int j =0;j*j+i<=n;j++){
                dp[i+j*j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
