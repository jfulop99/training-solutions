package week07d05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveInput {


    public void writeFile() {

        String[] lines = inputLines();
        File file = inputFileName();
        try (PrintWriter out = new PrintWriter(new FileWriter(file))){
            for (int i = 0; i < lines.length; i++) {
                out.println(lines[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String[] inputLines(){
        Scanner scanner = new Scanner(System.in);
        String [] lines = new String[3];
        for (int i = 0; i < lines.length; i++) {
            System.out.println(i + 1 + ". sor:");
            lines[i] = scanner.nextLine();
        }
        scanner.close();
        return lines;
    }

    private File inputFileName() {
        File file;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename:");
        file = new File(scanner.nextLine());
        scanner.close();
        return file;
    }

    public static void main(String[] args) {
        SaveInput saveInput = new SaveInput();

        saveInput.writeFile();
    }
}
