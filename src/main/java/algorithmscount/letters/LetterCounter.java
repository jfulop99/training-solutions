package algorithmscount.letters;

public class LetterCounter {

    public int countLetters(String letters, char letter) {
        int counter = 0;
        for (char letterItem:letters.toCharArray()) {
            if (letterItem == letter) {
                counter++;
            }
        }
        return counter;
    }
}
