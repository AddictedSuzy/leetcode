/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Earl_iu
 */
public class ThreeSum_15 {
    public static void main(String agrs[]){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List s = new ArrayList();
        List t = new ArrayList();
        int n = nums.length;
        for(int i =0;i<n;i++){
            s.add(nums[i]);
        }
        for(int j =0;j<n-2;j++){
            for(int k = j+1;k<n-1;k++){
                int want = 0 - nums[j] - nums[k];
                 s.remove((Integer)nums[j]);
                 s.remove((Integer)nums[k]);
                 if(s.contains(want)){
                    int[] temp = {nums[j],nums[k],want};
                    Arrays.sort(temp);
                    for(int i=0;i<3;i++){
                        t = new ArrayList();
                        t.add(temp[0]);
                        t.add(temp[1]);
                        t.add(temp[2]);
                    }
                    if(!res.contains(t)){
                        res.add(t);
                    }
                 }
                 s.add(nums[j]);
                 s.add(nums[k]);
            }
        }
        return res;
    }
    
    public static List<List<Integer>> ele(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i+2<nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;       /// skip same result
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
