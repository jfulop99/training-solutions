package controlselection.accents;

public class WithoutAccents {

    private final static String accents = "áÁéÉíÍóÓöÖőŐüÜűŰ";
    private final static String withoutAccent = "aAeEiIoOoOoOuUuU";

    public char cutAccent(char character){
        int i = accents.indexOf(character);
        if (i >= 0){
            return withoutAccent.charAt(i);
        }
        else {
            return character;
        }
    }
}
