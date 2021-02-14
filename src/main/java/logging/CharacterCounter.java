package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterCounter {

    public static final Logger LOGGER = LoggerFactory.getLogger(CharacterCounter.class);

    public int countCharacters(String source) {
        LOGGER.info("countCharacters: " + source);
        int counter = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == 'b') {
                LOGGER.info("b: " + i);
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new CharacterCounter().countCharacters("abababac"));
    }
}
