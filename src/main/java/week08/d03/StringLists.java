package week08.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringLists {

    private List<String> shortestWords;

    public StringLists() {
        shortestWords = new ArrayList<>();
    }

    public List<String> shortestWords(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }
        for (String word:words) {
            if (word != null) {
                int size = shortestWords.size();
                if (size != 0 && shortestWords.get(0).length() == word.length()) {
                    shortestWords.add(word);
                }
                if (size != 0 && shortestWords.get(0).length() > word.length()) {
                    shortestWords.clear();
                    size = 0;
                }
                if (size == 0) {
                    shortestWords.add(word);
                }
            }
        }
        return shortestWords;
    }

    public List<String> shortestWords2(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }
        int minLength = Integer.MAX_VALUE;
        for (String word:words) {
            if (word != null) {
                if (minLength > word.length()) {
                    shortestWords.clear();
                    minLength = word.length();
                }
                if (minLength == word.length()) {
                    shortestWords.add(word);
                }
            }
        }
        return shortestWords;
    }

    public List<String> shortestWords3(List<String> words) {
        int shortest = findShortest(words);
        shortestWords.clear();
        for (String word:words) {
            if (word != null && word.length() == shortest) {
                shortestWords.add(word);
            }
        }
        return shortestWords;
    }

    private int findShortest(List<String> words) {
        int shortest = Integer.MAX_VALUE;
        for (String word:words) {
            if (word != null && word.length() < shortest) {
                shortest = word.length();
            }
        }
        return shortest;
    }


    public static void main(String[] args) {
        StringLists stringLists = new StringLists();

        System.out.println(stringLists.shortestWords(Arrays.asList("aaa", null, "aa", "bb", "cccc", "dd")));

        System.out.println(stringLists.shortestWords2(Arrays.asList("aaa", null, "aa", "bb", "cccc", "dd")));

        System.out.println(stringLists.shortestWords3(Arrays.asList("aaa", null, "aa", "bb", "cccc", "dd")));

    }
}
