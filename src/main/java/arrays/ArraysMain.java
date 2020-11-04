package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int [] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {
        return Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütürtök", "Péntek", "Szombat", "Vasárnap");
    }

    public String multiplicationTableAsString(int size) {
        int [] [] table = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                table [i] [j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(table);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean wonLottery(int[] bet, int[] winner) {
        int[] copyOfBet = Arrays.copyOf(bet, bet.length);
        int[] copyOfWinner = Arrays.copyOf(winner, winner.length);

        Arrays.sort(copyOfBet);
        Arrays.sort(copyOfWinner);

        return Arrays.equals(copyOfBet, copyOfWinner);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println();
        System.out.println(arraysMain.daysOfWeek());
        System.out.println();
        System.out.println(arraysMain.multiplicationTableAsString(5));

        System.out.println();
        System.out.println(arraysMain.sameTempValues(new double[] {1, 2, 3}, new double[] {1, 2, 3}));
        System.out.println(arraysMain.sameTempValues(new double[] {1, 2, 3}, new double[] {3, 2, 1}));

        int[] winner = new int[]{5, 1, 4, 63, 44};
        int[] bet = new int[]{6, 1, 4, 63, 44};
        System.out.println();
        System.out.println(arraysMain.wonLottery(bet, winner));
        System.out.println(Arrays.toString(bet));
        System.out.println(Arrays.toString(winner));
    }
}
