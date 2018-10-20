/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.LinkedList;

/**
 *
 * @author Earl_iu
 */
public class findMedianSortedArrays_4 {
    public static void main(String args[]){
        int[] a = {};
        int[] b = {6};
        double c = find(a,b);
        System.out.println(c);
       
    }
    
    public static double find(int[] nums1, int[] nums2) {
        double median;
        int[] nums3 = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){
                nums3[k] = nums2[j];
                j++;
                k++;
            }else if(nums1[i]<=nums2[j]){
                nums3[k] = nums1[i];
                i++;
                k++;
            }
        }
        if(i<nums1.length){
            while(i<nums1.length){
                nums3[k] = nums1[i];
                k++;
                i++;
            }
        }else if(j<nums2.length){
            while(j<nums2.length){
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        int left = (nums1.length+nums2.length)%2;
        boolean flag = false;
        if(left>0){
            flag = true;
        }
        int count = Math.round((nums1.length+nums2.length)/2);
        if(flag){
            median = (double)nums3[count];
        }else{
            median = (nums3[count]+nums3[count-1])/2.0;
        }
        return median;
    }
}
