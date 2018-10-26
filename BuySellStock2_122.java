/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author Earl_iu
 */
public class BuySellStock2_122 {
    public static void main(String args[]){
        int[] p = {7,1,3,5,6,4};
        System.out.println(bestWay(p));
    }
    
    public static int bestWay(int[] prices){
       int profit = 0;
        for(int i = 1;i<prices.length;i++){
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
        }
    
    /** 为什么我们可以用这种方法呢：
     *  当数组是一个递增的时候时，那么肯定是最大值减最小值，相当于，每两个数之间的差值
     *  如果是先递增再递减再递增，例如 5，3，2，9 那么最大值肯定还是9-2
     */
    
}
