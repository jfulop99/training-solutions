package week05.d05;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    //Write your code here
//    public static final int B;
//    public static final int H;
//    public static boolean flag;
//
    static {
//        Scanner sc = new Scanner(System.in);
//        B = sc.nextInt();
//        H = sc.nextInt();
//        if(B <= 0 || H <=0){
//            System.out.println("java.lang.Exception: Breadth and height must be positive");
//            flag = false;
//        }
//        else{
//            flag = true;
//        }
    }

    public static void main(String[] args){
//        if(flag){
//            int area=B*H;
//            System.out.println(area);
//
//        }

        System.out.println(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(123.2544));

    }//end of main

}
