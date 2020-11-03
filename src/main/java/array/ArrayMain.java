package array;

public class ArrayMain {
    public static void main(String[] args) {
        String weekDays[] = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};

        System.out.println("A második elem: " + weekDays[1] + ", a tömb hossza: " + weekDays.length + ".");

        int [] twoPows = new int[5];
        int pow = 1;
        for (int i = 0; i < twoPows.length; i++) {
            twoPows[i] = pow;
            pow = pow * 2;
        }
        for (int j : twoPows  ) {
            System.out.println(j);
        }

        boolean[] arrayOfboolean = new boolean[6];
        boolean flag = false;
        for (int i = 0; i < arrayOfboolean.length; i++) {
            arrayOfboolean[i] = flag;
            flag = !flag;
        }
        for (boolean temp: arrayOfboolean ) {
            System.out.println(temp);
        }
    }
}
