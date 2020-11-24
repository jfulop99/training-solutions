package training;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {

    @Test
    void testCreateEmployee() {
        new EmployeeService().createEmployee("Jack Doe", 1970, EmployeeType.FULL_TIME);
    }

    @Test
    void testFind() {
        List<String> names = Arrays.asList("John Doe", "Jane Doe", "Jack Doe");
        Result result = new EmployeeService().findEmployee("Jane", names);

        assertEquals("Jane Doe", result.getName());
        assertEquals(1, result.getIndex());
    }

    @Test
    void testList() {
        List<String> names = new EmployeeService().listNames();
        for (String name:names) {
            System.out.println(name);
        }
    }
}
