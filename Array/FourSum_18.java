/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Earl_iu
 */
public class FourSum_18 {
    public static void main(String args[]){
        int[] nums = {1, 0, -1, 0, -2, 2};
        List l = fourSum(nums,0);
        Iterator ite = l.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
    }
    
    public static List<List<Integer>> fourSum(int[] nums, int target) { 
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i+3<nums.length;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int head = j+1;
                int tail = nums.length - 1;
                while(head<tail){
                    int tempSum = nums[i]+nums[j]+nums[tail]+nums[head];
                    if(tempSum== target){
                        List<Integer> item = new ArrayList<>();
    			item.add(nums[i]);
    			item.add(nums[j]);
    			item.add(nums[head]);
    			item.add(nums[tail]);
    			if (res.contains(item) == false) {
                            res.add(item);
    			} 
                        tail--;
                        head++;
                    }else if(tempSum < target){
                        head++;
                    }else{
                        tail--;
                    }
                }
            }
        }
        return res;
     }
}
