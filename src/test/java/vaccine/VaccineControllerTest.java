package vaccine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VaccineControllerTest {

    private VaccineController vaccineController;

    @BeforeEach
    void setUp() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccine_control?useUnicode=true");
            dataSource.setUser("vaccine");
            dataSource.setPassword("vaccine");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not create datasource", sqlException);
        }

        vaccineController = new VaccineController(dataSource);
    }

    @Test
    void readCitizensFromFile() throws IOException {

        List<Citizen> citizens;
        try (BufferedReader reader = Files.newBufferedReader(Path.of("teszt.csv"))) {
            citizens = vaccineController.readCitizensFromFile(reader);
        }
        assertEquals(2979, citizens.size());
    }
}