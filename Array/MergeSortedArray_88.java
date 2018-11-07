/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;

/**
 *
 * @author Earl_iu
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Example:
 *      Input:
 *      nums1 = [1,2,3,0,0,0], m = 3
 *      nums2 = [2,5,6],       n = 3
 *      output:
 *      [1,2,2,3,5,6]
 */


public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointera = m - 1 ;
        int pointerb = n - 1;
        int pointermerge = m + n - 1;
        while(pointera != -1 && pointerb != -1) {
	        if (nums1[pointera] > nums2[pointerb]) {
		    nums1[pointermerge] = nums1[pointera];
		    nums1[pointera--] = nums2[pointerb];
	        } else {
		        nums1[pointermerge] = nums2[pointerb--];
	        }
            pointermerge--;
        }
         while (pointerb != -1) {
	    nums1[pointermerge--] = nums2[pointerb--];
        }
    }
}
