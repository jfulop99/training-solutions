package week04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    List<Integer> getIndexesOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();
        int found = 0;
        int fromIndex = 0;
        while (fromIndex <= str.length()-1) {
            found = str.indexOf(c, fromIndex);
            if (found >= 0) {
                result.add(found);
                fromIndex = found +1;
            }
            else {
                fromIndex = str.length();
            }
        }
        return result;
    }

        public static void main(String[] args) {
        Main main = new Main();

            String str = "Abrkadabra";
            char c = 'a';
            System.out.println(main.getIndexesOfChar(str,c));

        }


}
