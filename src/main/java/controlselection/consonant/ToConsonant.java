package controlselection.consonant;

import intromethods.Todo;

public class ToConsonant {
    private static final String wowels = "AEIOU";

    public String toConsonant(String character){
        if (wowels.indexOf(character.toUpperCase().charAt(0)) >= 0){
            return Character.toString(character.toCharArray()[0]+1);
        }
        else{
            return character;
        }
    }
}
