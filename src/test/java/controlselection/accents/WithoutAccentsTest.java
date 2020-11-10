package controlselection.accents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WithoutAccentsTest {
    private final static String accents = "áÁéÉíÍóÓöÖőŐüÜűŰ";
    private final static String withoutAccent = "aAeEiIoOoOoOuUuU";
    @Test
    void testcutAccent(){
        WithoutAccents withoutAccents = new WithoutAccents();
        String orig = "";
        String converted = "";
        for (int i = 0; i < accents.length(); i++){
            assertEquals(withoutAccent.charAt(i), withoutAccents.cutAccent(accents.charAt(i)));
            orig = orig + accents.charAt(i);
            converted = converted + withoutAccents.cutAccent(accents.charAt(i));
        }
        System.out.println("Original:  " + orig);
        System.out.println("Converted: " + converted);
    }
    @Test
    void testAll(){
        WithoutAccents withoutAccents = new WithoutAccents();
        String orig = "";
        String converted = "";
        for (char i = 'A'; i <= 'z'; i++){
            assertEquals(i, withoutAccents.cutAccent(i));
            orig = orig + i;
            converted = converted + withoutAccents.cutAccent(i);
        }
        System.out.println("Original:  " + orig);
        System.out.println("Converted: " + converted);
    }
}
