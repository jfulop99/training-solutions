package week05d02;

public class ChangeLetter {

    public String  changeVowels(String input){
        if (input == null) {
            throw new IllegalArgumentException("Invalid input: null");
        }
        String vowels = "aAeEiIoOuU";
        StringBuilder temp = new StringBuilder(input);
        for (int i=0; i<temp.length(); i++) {
            if (vowels.indexOf(temp.charAt(i)) >= 0) {
                temp.setCharAt(i, '*');
            }
        }
        return temp.toString();
    }

    public String changeVowels2(String input){

        if (input == null) {
            throw new IllegalArgumentException("Invalid input: null");
        }
        String vowels = "aAeEiIoOuU";
        String output ="";
        for (char c: input.toCharArray()) {
            if (vowels.indexOf(c) >= 0) {
                output = output + '*';
            }
            else {
                output = output + c;
            }
        }
    return output;
    }
}
