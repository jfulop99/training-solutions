package week13.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {


    public String merge(Path file, List<Employee> employees) {
        StringBuilder formatted = new StringBuilder();

        String template = readTemplateFromFile(file);

        for (Employee employee:employees) {
            formatted.append(lineFormatter(employee, template));
        }


        return formatted.toString();
    }

    private String lineFormatter(Employee employee, String template) {

        String line = template.replace("{nev}", employee.getName());
        line = line.replace("{ev}", Integer.toString(employee.getYearOfBirth()));
        return line + "\n";

    }

    private String readTemplateFromFile(Path file) {

        String template = null;
        try (BufferedReader reader = Files.newBufferedReader(file)){
                template = reader.readLine();
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return template;
    }


    public static void main(String[] args) {

        TemplateMerger templateMerger = new TemplateMerger();

        List<Employee> employeeList = List.of(new Employee("John Doe", 1980),
                new Employee("Jane Doe", 1970),
                new Employee("Jack Doe", 1961));

        System.out.println(templateMerger.merge(Path.of("juniortemplate.txt"), employeeList));
    }
}
