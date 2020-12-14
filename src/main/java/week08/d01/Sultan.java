package week08.d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {


    private final static int NUMBER_OF_DOORS = 100;
    private final static int NUMBER_OF_DAYS = NUMBER_OF_DOORS;

    private boolean[] doors = new boolean[NUMBER_OF_DOORS];


    public List<Integer> openDoors() {

        calculate2();

        List<Integer> opendoors = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_DOORS; i++) {
            if (doors[i]) {
                opendoors.add(i + 1);
            }
        }
        return opendoors;
    }

    private void calculate() {

        for (int i = 0; i < NUMBER_OF_DAYS; i++) {
            for (int j = 0; j < NUMBER_OF_DOORS; j++) {
                if ((j + 1) % (i + 1) == 0) {
                    doors[j] = !doors[j];
                }
            }
        }
    }
    private void calculate2() {

        for (int i = 0; i < NUMBER_OF_DAYS; i++) {
            for (int j = i; j < NUMBER_OF_DOORS; j+=(i+1)) {
                doors[j] = !doors[j];
            }
        }


    }

    public static void main(String[] args) {
        Sultan sultan = new Sultan();
        System.out.println(sultan.openDoors());
    }
}
