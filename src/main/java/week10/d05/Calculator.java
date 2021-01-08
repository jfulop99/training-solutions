package week10.d05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public void findMinMaxSum(int[] arr) {
        int minSum = 0;
        int maxSum = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        for (int num:arr){
            if(num1==0 || num > num1) {
                num4 = num3;
                num3 = num2;
                num2 = num1;
                num1 = num;
            }else if(num2 == 0 || num > num2) {
                num4 = num3;
                num3 = num2;
                num2 = num;
            }else if(num3 == 0 || num > num3) {
                num4 = num3;
                num3 = num;
            }else if(num4 == 0 || num > num4) {
                num4 = num;
            }
        }
        maxSum = num1 + num2 + num3 +num4;

        for (int num:arr){
            if(num1==0 || num < num1) {
                num4 = num3;
                num3 = num2;
                num2 = num1;
                num1 = num;
            }else if(num2 == 0 || num < num2) {
                num4 = num3;
                num3 = num2;
                num2 = num;
            }else if(num3 == 0 || num < num3) {
                num4 = num3;
                num3 = num;
            }else if(num4 == 0 || num < num4) {
                num4 = num;
            }
        }
        minSum = num1 + num2 + num3 +num4;


        System.out.println(String.format("Minimum összeg: %d Maximum összeg: %d", minSum, maxSum));
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String input = "start";
        while (input.length() > 0) {
            input = sc.nextLine();
            try {
                numbers.add(Integer.parseInt(input));
            }catch (NumberFormatException e) {
                System.out.println("Bevitel vége");
            }
        }

        int[] arr = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            arr[i] = numbers.get(i);
        }

        System.out.println(arr.length);
        for (int num:arr) {
            System.out.println(num);

        }

        Calculator calc = new Calculator();
        calc.findMinMaxSum(arr);

    }

}
