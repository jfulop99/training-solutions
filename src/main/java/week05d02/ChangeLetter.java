package week05d02;

public class ChangeLetter {

    public static final String VOWELS = "aEiIAeoOuU";

    public String  changeVowels(String input){
        if (input == null) {
            throw new IllegalArgumentException("Invalid input: null");
        }
        StringBuilder temp = new StringBuilder(input);
        for (int i=0; i<temp.length(); i++) {
            if (VOWELS.indexOf(temp.charAt(i)) >= 0) {
                temp.setCharAt(i, '*');
            }
        }
        return temp.toString();
    }

    public String changeVowels2(String input){

        if (input == null) {
            throw new IllegalArgumentException("Invalid input: null");
        }
        StringBuilder output = new StringBuilder();
        for (char c: input.toCharArray()) {
            if (VOWELS.indexOf(c) >= 0) {
                output.append("*");
            }
            else {
                output.append(c);
            }
        }
    return output.toString();
    }
}
