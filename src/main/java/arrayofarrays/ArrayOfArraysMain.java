package arrayofarrays;

import java.util.Scanner;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {
        int [] [] table = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                table [i] [j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
    public void printArrayOfArrays(int[][] a) {
        String temp = "";
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a [i].length; j++) {
                if (a [i] [j] >= 100) {
                    temp = temp + " " + a [i] [j];
                }
                else {
                    if (a[i][j] >= 10) {
                        temp = temp + "  " + a[i][j];
                    }
                    else {
                        temp = temp + "   " + a [i] [j];
                    }
                }
            }
            System.out.println(temp);
            temp = "";
        }
    }

    public int[][] triangularMatrix(int size) {
        int [] [] table = new int[size][];
        for (int i = 0; i < size; i++) {
            table [i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                table [i] [j] = i;
            }
        }
        return table;
    }

    public int[][] getValues() {
        int [] [] table = new int [12][];
        // Ez volt a saját megoldásom
//        table [0] = new int[31];
//        table [1] = new int[28];
//        table [2] = new int[31];
//        table [3] = new int[30];
//        table [4] = new int[31];
//        table [5] = new int[30];
//        table [6] = new int[31];
//        table [7] = new int[31];
//        table [8] = new int[30];
//        table [9] = new int[31];
//        table [10] = new int[30];
//        table [11] = new int[31];
        // Ezt szebbnek találtam
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < numberOfDays.length; i++) {
            table [i] = new int[numberOfDays[i]];
        }

        return table;
    }

    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg a szorzótábla méretét!");
        int [] [] a = arrayOfArraysMain.multiplicationTable(scanner.nextInt());
        arrayOfArraysMain.printArrayOfArrays(a);

        System.out.println("Add meg a háromszög méretét!");
        int [] [] b = arrayOfArraysMain.triangularMatrix(scanner.nextInt());
        arrayOfArraysMain.printArrayOfArrays(b);
        System.out.println("A hónapok napja:");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.getValues());
    }
}
