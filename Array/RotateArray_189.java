/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;

/**
 *
 * @author Earl_iu
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * solution:
 * nums = [1,2,3,4,5,6,7] and k = 3
 * first we reverse [1,2,3,4], it becomes[4,3,2,1]
 * then we reverse[5,6,7], it becomes[7,6,5]
 * finally we reverse the array as a whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].
 */

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return;
        }   
        
        k = k%nums.length; // 当k>nums.length的时候，减少重复的工作
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
        
    }
    public void reverse(int[] nums, int start,int end){
        int temp = 0;
        while(start<end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public void rotate_2(int[] nums, int k) {
        k = k%nums.length;
        int[] num = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            num[i] = nums[i];
        }
        for(int i =0;i<nums.length;i++){
            nums[i] = num[(nums.length-k+i)%nums.length];
        }
    }
}
