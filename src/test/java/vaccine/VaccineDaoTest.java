package vaccine;

import org.flywaydb.core.Flyway;
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

class VaccineDaoTest {

    VaccineDao vaccineDao;

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


        vaccineDao = new VaccineDao(dataSource);

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/vaccine")
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();


    }

    @Test
    void readCitizensFromFile() throws IOException {
        List<Citizen> citizens;
        try (BufferedReader reader = Files.newBufferedReader(Path.of("registered_tesztfile.csv"))) {
            citizens = vaccineDao.readCitizensFromFile(reader);
        }
        assertEquals(3014, citizens.size());
    }

    @Test
    void selectPostalCode() {
        assertEquals("Szentendre", vaccineDao.selectPostalCode("2000").get(0).getCity());
        assertEquals(2, vaccineDao.selectPostalCode("8999").size());
        assertEquals("Zalalövő", vaccineDao.selectPostalCode("8999").get(0).getCity());
        assertEquals("Csöde", vaccineDao.selectPostalCode("8999").get(1).getCity());
    }

    @Test
    void insertCitizens() throws IOException {
        List<Citizen> citizens;
        try (BufferedReader reader = Files.newBufferedReader(Path.of("registered_tesztfile.csv"))) {
            citizens = vaccineDao.readCitizensFromFile(reader);
        }
        assertEquals(3014, citizens.size());

        citizens = vaccineDao.insertCitizens(citizens);
        assertEquals(3014, citizens.size());
    }

}