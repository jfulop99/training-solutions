package week09.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Present {

    TOY, ELECTRONIC, HOUSEKEEPING, DECORATION;


    private static final List<Present> PRESENTS = new ArrayList<>(Arrays.asList(values()));
    private static final Random RND = new Random();


    public static Present randomPresent() {
        return PRESENTS.get(RND.nextInt(PRESENTS.size()));
    }

}
