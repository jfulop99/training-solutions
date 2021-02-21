package xtest.spring;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
class EmployeeDaoTest {

    @Autowired
    private Flyway flyway;

    @Autowired
    private EmployeeDao employeeDao;

    @BeforeEach
    public void setUp() {

        flyway.clean();
        flyway.migrate();
    }

    @Test
    void testCreateEmployee() {
        employeeDao.createEmployee("John Doe");
        List<String> employees = employeeDao.listEmployeeNames();

        assertEquals(Arrays.asList("John Doe"), employees);

    }
}