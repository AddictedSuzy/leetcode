/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author Earl_iu
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDupSortedArray_26 {
   public static void main(String agrs[]){
       int[] a = {1,2,4,5,5,7};
       removeDuplicates(a);
   }
   
   // 用两个指针来跟踪数组，当i==j的时候，我们跳过这些重复，直到i!=j，然后我们将j的值赋值给i+1
   public static int removeDuplicates(int[] nums) {
    int i = 0;
    int j;
    for(j=1;j<nums.length;j++){
        if(nums[j] != nums[i]){
            i++;
            nums[i] = nums[j];
        }
    }
        return i+1;    
    }
}
