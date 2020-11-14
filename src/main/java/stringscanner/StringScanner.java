package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {


    public int readAndSumValues(String intString, String delimiter) {
        Scanner scanner;
        if (isEmpty(intString)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (!isEmpty(delimiter)) {
            scanner = new Scanner(intString).useDelimiter(delimiter);
        }
        else {
            scanner = new Scanner(intString);
        }
        int sum = 0;
        try {
        while (scanner.hasNext()){
                sum += scanner.nextInt();
            }
        }catch (InputMismatchException e){
            throw new IllegalArgumentException("Incorrect parameter string!", e);
        }

        return sum;
    }

    public int readAndSumValues(String intString) {
        if (isEmpty(intString)) {
            throw new IllegalArgumentException("Empty string!");
        }
        Scanner scanner = new Scanner(intString);
        int sum = 0;
        try {
            while (scanner.hasNext()){
                sum += scanner.nextInt();
            }
        }catch (InputMismatchException e){
            throw new IllegalArgumentException("Incorrect parameter string!", e);
        }

        return sum;
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || isEmpty(word) || text.trim().equals("")) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        StringBuilder filter = new StringBuilder();
        Scanner scanner = new Scanner(text);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.contains(word)) {
                filter.append(line);
                filter.append('\n');
            }
        }
        return filter.toString().trim();
    }

    private boolean isEmpty(String string) {
        return (string == null || string.equals(""));
    }
}
