package week02d05;

import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Java", "Python", "Javascript");
        for (String elem: lista) {
            if (elem.length() > 5){
                System.out.println(elem);
            }
        }
    }
}
