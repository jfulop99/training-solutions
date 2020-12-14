package week07.d05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    private Scanner scanner;

    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printFile() {

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
//        Scanner scanner = new Scanner(System.in);
        String [] lines = new String[3];
        for (int i = 0; i < lines.length; i++) {
            System.out.println(i + 1 + ". sor:");
            lines[i] = scanner.nextLine();
        }
        return lines;
    }

    private File inputFileName() {
        File file;
//        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename:");
        file = new File(scanner.nextLine());
        return file;
    }


    public void writeFile() {
            List<String> lines = readLines();
            Path path = readFileName();
        try {
            Files.write(path, lines);
            } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public void writeFile(Path path, List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    private List<String> readLines() {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1 + ". sor:");
            lines.add(scanner.nextLine());
        }
        return lines;
    }

    private Path readFileName() {
        Path path;
        System.out.println("Enter filename:");
        path = Path.of(scanner.nextLine());
        return path;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SaveInput saveInput = new SaveInput(scanner);

        //saveInput.printFile();
        saveInput.writeFile();
    }
}
