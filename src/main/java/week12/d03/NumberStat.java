package week12.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberStat {

    public int findNumber(List<Integer> numbers) {

        List<Integer> result = new ArrayList<>(numbers);
        Collections.sort(result);
        Collections.reverse(result);

        Integer prevNumber = result.get(0);
        int ret = 0;
        int counter = 0;
        for (Integer item:result) {
            if (prevNumber.equals(item)) {
                counter++;
            }
            else {
                if (counter == 0) {
                    ret = prevNumber.intValue();
                }
                counter = 0;
            }
            prevNumber = item;
        }


        return ret;
    }


    public static void main(String[] args) {
        System.out.println(new NumberStat().findNumber(Arrays.asList(1,1,5,3,4,5,6,5,6,4,1,6,5,4)));
    }
}
