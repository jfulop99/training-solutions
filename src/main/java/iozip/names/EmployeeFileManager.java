package iozip.names;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public void saveEmployees(Path path, List<String> names) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))){
            zipOutputStream.putNextEntry(new ZipEntry("names.dat"));

            for (String item:names) {

                zipOutputStream.write(item.getBytes());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeFileManager employeeFileManager = new EmployeeFileManager();
        employeeFileManager.saveEmployees(Path.of("data.zip"), Arrays.asList("John Doe","Jack Doe","Jane Doe"));
    }
}
