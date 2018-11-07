/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;

import java.util.Arrays;

/**
 *
 * @author Earl_iu
 */
public class TargetSum_494 {
    public static void main(String args[]){
        int[] nums = {1,0};
        TargetSum_494 sm = new TargetSum_494();
        System.out.println(sm.findTargetSumWays(nums,1));
    }
    public int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        sums(nums,0,nums[0],S);
        sums(nums,0,-nums[0],S);
        return count;
    }
    
    public void sums(int[] nums,int index,int sum, int S){
        if(sum == S && index == nums.length-1){
            count ++; 
        }
        else if(index<nums.length-1){
            sums(nums,index+1,sum+nums[index+1],S);
            sums(nums,index+1,sum-nums[index+1],S);    
        }
    }
    
    public int elegant(int[] nums, int S) {   // 前一种方法中出现了大量的重复，导致运算量很大，这种方法，我们保存出现过的值
        int[][] memo = new int[nums.length][2001];  
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }
}
