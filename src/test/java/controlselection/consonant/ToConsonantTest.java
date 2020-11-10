package controlselection.consonant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToConsonantTest {
    @Test
    void testWowels(){

        ToConsonant toConsonant = new ToConsonant();

        for (char i : "aeiou".toCharArray()) {
            assertEquals(Character.toString(i+1), toConsonant.toConsonant(Character.toString(i)));
            System.out.println((char)(i+1));
        }
    }

    @Test
    void testConsenants(){

        ToConsonant toConsonant = new ToConsonant();

        for (char i : "bcdfghjklmnpqrstvwxyz".toCharArray()) {
            assertEquals(Character.toString(i), toConsonant.toConsonant(Character.toString(i)));
        }
    }
}
