package week13.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateMergerTest {

    @Test
    void merge() {

        TemplateMerger templateMerger = new TemplateMerger();

        List<Employee> employeeList = List.of(new Employee("John Doe", 1980),
                new Employee("Jane Doe", 1970),
                new Employee("Jack Doe", 1961));

        String result = "Az alkalmazott neve: John Doe, születési éve: 1980\n" +
                "Az alkalmazott neve: Jane Doe, születési éve: 1970\n" +
                "Az alkalmazott neve: Jack Doe, születési éve: 1961\n";

        assertEquals(result, templateMerger.merge(Path.of("juniortemplate.txt"), employeeList));


    }
}