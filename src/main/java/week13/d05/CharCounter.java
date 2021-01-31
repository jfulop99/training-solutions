package week13.d05;

import java.util.regex.Pattern;

public class CharCounter {

    public long counter(String words) {

        return Pattern.compile("[a-zA-Z]").matcher(words).results().count();

    }

}
