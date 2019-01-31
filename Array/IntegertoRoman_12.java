/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Array;

/**
 *
 * @author Earl_iu
 */
public class IntegertoRoman_12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
    
    public static String intToRoman(int num){
        int len = String.valueOf(num).length();
        String s = "";
        while(len>0){
            if(len==1){
                help(num,len);
                s += help(num,len);    
                len--;
            }else if(len==2){
                int in = num/10;
                s += help(in, len);
                num = num- in*10;
                len--;
            }else if(len==3){
                int in = num/100;
                s += help(in,len);
                num = num - in*100;
                len--;
            }else{
                int in = num/1000;
                len = 4;
                s += help(in,len);
                num = num -in*1000;
                len--;
            }
        }
        return s;
    }
    
    public static String help(int in, int len){
        String[] s = {"I","V","X","L","C","D","M",null,null};
        String a = s[(len-1)*2];
        String b = s[(len-1)*2+1];
        String c = s[(len-1)*2+2];
        
        switch(in){
            case 1:
                return a;
            case 2:
                return a + a;
            case 3:
                return a + a + a;
            case 4:
                return a + b;
            case 5:
                return b;
            case 6:
                return b + a;
            case 7:
                return b + a + a;
            case 8:
                return b + a + a + a;
            case 9:
                return a + c;
        }
        return "";
    }
    
}
