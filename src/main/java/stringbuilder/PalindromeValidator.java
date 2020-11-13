package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String string){
        if (string == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        StringBuilder palindrome = new StringBuilder();
        palindrome.append(string.trim().toLowerCase());
        palindrome.reverse();
        return string.trim().toLowerCase().equals(palindrome.toString());
    }
}
