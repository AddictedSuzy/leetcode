/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;

/**
 *
 * @author Earl_iu
 * 回文数，即正过来和倒过来是同一个数 例如121
 */
public class PalindromeNumber_9 {
    public static void main(String agrs[]){
        System.out.println(solution(101));
    }
    public static boolean solution(int x){
        int res = 0;
        if(x<0){
            return false;
        }
        int xf = x;
        while(xf!=0){           // 将数字倒过来
            int tail = xf%10;
            res = res*10+tail;
            xf = xf/10;
        }
        if(x==res){
            return true;
        }else{
            return false;
        }
    }
}
