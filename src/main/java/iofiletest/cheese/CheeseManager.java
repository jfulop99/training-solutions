package iofiletest.cheese;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheeseManager {

    public static void saveToFile(Path file, List<Cheese> cheeses) {
        try (DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))){
            for (Cheese cheese:cheeses) {
                writer.writeUTF(cheese.getName());
                writer.writeDouble(cheese.getAmountOfLactose());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public static Cheese findCheese(Path file, String findName) {
        try (DataInputStream reader = new DataInputStream(new BufferedInputStream(Files.newInputStream(file)))){
            String name;
            while (reader.available() > 0) {
                name = reader.readUTF();
                if (name.equals(findName)) {
                    return new Cheese(name, reader.readDouble());
                }
                reader.readDouble();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return null;
    }

    public static void main(String[] args) {
        List<Cheese> cheeses = new ArrayList<>(Arrays.asList(new Cheese("Gruyere", 1.23),
                new Cheese("Trapista", 2.34),
                new Cheese("Ementáli", 4.23),
                new Cheese("Camenbert", 0.23)));

        CheeseManager.saveToFile(Path.of("temp/sajtok.dat"), cheeses);

        System.out.println(findCheese(Path.of("temp/sajtok.dat"), "Karaván"));
        System.out.println(findCheese(Path.of("temp/sajtok.dat"), "Trapista"));
    }
}
