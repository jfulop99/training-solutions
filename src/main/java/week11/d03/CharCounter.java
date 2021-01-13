package week11.d03;

import java.util.*;

public class CharCounter {

    public static int countChars(String[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        int result = 0;
        int numberOfWords = chars.length;
        List<Character> characters = new ArrayList<>();
        for (String item:chars) {
                for (Character letter : item.toCharArray()) {
                    characters.add(letter);
                }
        }
        Collections.sort(characters);
        Character prevChar = characters.get(0);
        int counter = 0;
        for (Character letter:characters) {
            counter++;
            if (prevChar.equals(letter)) {
                if (counter == numberOfWords) {
                    result++;
                    counter = 0;
                }
            }
            else {
                prevChar = letter;
            }
        }
        return result;
    }

    public static int countChars2(String[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        int result = 0;
        int numberOfWords = chars.length;
        List<Character> characters = new ArrayList<>();
        for (String item:chars) {
            for (Character letter:item.toCharArray()) {
                characters.add(letter);
            }
        }
        Set<Character> setOfCharacters= new HashSet<>(characters);
        for (Character item:setOfCharacters) {
            if (Collections.frequency(characters, item) == numberOfWords) {
                result++;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(countChars(new String[]{"abc", "cba", "ab"}));
        System.out.println(countChars2(new String[]{"abc", "cba", "ab"}));
    }

}
