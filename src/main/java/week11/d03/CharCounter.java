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
                    if (!characters.contains(letter)){
                        characters.add(letter);
                    }
                }
        }
        int counter = 0;
        for (Character item : characters) {
            for (String word : chars ) {
                if (word.indexOf(item) >= 0) {
                    counter++;
                    if (counter == numberOfWords) {
                        result++;
                        counter = 0;
                    }
                }
            }
        }
        return result;
    }

    public static int countChars2(String[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        int result = 0;

        Set<Character> setOfCharacters= new HashSet<>();
        for (String word: chars) {
            for (Character letter: word.toCharArray()) {
                setOfCharacters.add(letter);
            }
        }
        int numberOfWords = chars.length;
        int counter = 0;
        for (Character item : setOfCharacters) {
            for (String word : chars ) {
                if (word.indexOf(item) >= 0) {
                    counter++;
                    if (counter == numberOfWords) {
                        result++;
                        counter = 0;
                    }
                }
            }
        }
        return result;
    }

//  Órai megoldás
    public static int countChars3(String[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        int result = 0;

        if (chars.length > 0) {
            Set<Character> first = new HashSet<>();
            for (char c:chars[0].toCharArray() ) {
                first.add(c);
            }
            for (int i = 1; i < chars.length; i++) {
                Set<Character> next = new HashSet<>();
                for (char c : chars[i].toCharArray()) {
                    next.add(c);
                }
                first.retainAll(next);
            }
            result = first.size();
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(countChars(new String[]{"abc", "cba", "abb"}));
        System.out.println(countChars2(new String[]{"abc", "cba", "abb"}));
        System.out.println(countChars3(new String[]{"abc", "cba", "abb"}));
    }

}
