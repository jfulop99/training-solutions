package week09.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Present {

    TOY, ELECTRONIC, HOUSEKEEPING, DECORATION;


    private static final List<Present> PRESENTS = new ArrayList<>(Arrays.asList(values()));


    public static Present randomPresent(Random rnd) {
        return PRESENTS.get(rnd.nextInt(PRESENTS.size()));
    }

}
