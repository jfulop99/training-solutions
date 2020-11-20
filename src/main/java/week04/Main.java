package week04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    List<Integer> getIndexesOfChar1(String str, char c) {
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

    List<Integer> getIndexesOfChar2(String str, char c) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == c) {
                result.add(i);
            }
            i++;
        }
        return result;
    }

        public static void main(String[] args) {
        Main main = new Main();

            String str = "abrakadabra";
            char c = 'a';
            System.out.println(main.getIndexesOfChar1(str,c));

            System.out.println(main.getIndexesOfChar2(str,c));
        }


}
