package week04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<Integer> getIndexesOfChar1(String str, char c) {    // indexOf --> very difficult (20 minutes)
        List<Integer> result = new ArrayList<>();
        int foundPosition ;
        int fromIndex = 0;
        while (fromIndex <= str.length()-1) {
            foundPosition = str.indexOf(c, fromIndex);
            if (foundPosition >= 0) {
                result.add(foundPosition);
                fromIndex = foundPosition +1;
            }
            else {
                fromIndex = str.length();
            }
        }
        return result;
    }

    public List<Integer> getIndexesOfChar2(String str, char c) {    // charAt --> simple like the wedge (5 minutes)
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

    public List<Integer> getIndexesOfChar3(String str, char c) {    // recursive --> it was big challenge (40 minutes)
                                                                    // first recursion in my life !!!
        List<Integer> result = new ArrayList<>();

        String answer = countChar(str, c, 0);
        if (answer.length() > 0) {
            for (String item : answer.split(",")) {
                result.add(Integer.parseInt(item));
            }
        }
        return result;
    }

    public String countChar(String str, char c, int counter ) {
        if (str.length() == counter) {
            return "";
        }
        return (str.charAt(counter) == c ? "" + counter + "," : "") + countChar(str, c, counter + 1);
    }

    public static void main(String[] args) {
        Main main = new Main();

            String [] strarray ={ "abrakadabra", "xxxxxxxxx", "aaaaaaaaa", ""};
            char c = 'a';
        for (String str : strarray ) {

            System.out.println(main.getIndexesOfChar1(str, c));

            System.out.println(main.getIndexesOfChar2(str, c));

            System.out.println(main.getIndexesOfChar3(str, c));
        }
    }
}
