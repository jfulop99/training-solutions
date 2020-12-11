package week04d03;

import java.util.Scanner;

public class Test {

    public String filterLinesWithWordOccurrences(String text, String word) {
        String line = "";
        Scanner scanner = new Scanner(text);
        while (scanner.hasNextLine()) {
            String loopLine = scanner.nextLine();
//            while (scanner.hasNext()) {
//                String s = scanner.next();
                if (loopLine.contains(word)) {
                    line += loopLine + "\n";
                }
            }
//        }
        return line;
    }


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println( test.filterLinesWithWordOccurrences("alma word\nldlsdnlds\nkorte word\n", "word"));
    }
}
