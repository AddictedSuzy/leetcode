/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 * 
 * @author Earl_iu
 * 
 * 知识点：HashMap
 * 给出一个数组和一个目标值，得到目标值是否是数组中两数之和，如果是就返回两个数的index，例如[3,2,3] target = 6, return [0,2];
 * 
 */
public class TwoSum_1 {
    
    public static void main(String[] args){
        int[] num = {3,2,3};
        int[] n1 = twoSum_1(num,6);
        for(int i =0;i<n1.length;i++){
            System.out.print(i+" ");
        }
    }
    
    /*
        使用HashMap的两种方法：
    */
    public static int[] twoSum_1(int[] nums, int target){
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(hash.containsKey(complement)){
                return new int[]{hash.get(complement),i};
            }
            hash.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    public static int[] twoSum_2(int[] nums, int target){
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hash.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            int com = target - nums[i];
            if(hash.containsKey(com) && hash.get(com) != i){
                return new int[]{i,hash.get(com)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    } 
    
}
