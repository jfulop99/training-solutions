package vaccine;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void selectPostalCode() {
        assertEquals("Szentendre", vaccineDao.selectPostalCode("2000").get(0).getCity());
        assertEquals(2, vaccineDao.selectPostalCode("8999").size());
        assertEquals("Zalalövő", vaccineDao.selectPostalCode("8999").get(0).getCity());
        assertEquals("Csöde", vaccineDao.selectPostalCode("8999").get(1).getCity());
    }

    @Test
    void insertCitizens() {
        List<Citizen> citizens = List.of(new Citizen("John Doe", "8999", 43, "john.doe@java.com", "982553309"),
                new Citizen("Jane Doe", "2000", 33, "jane.doe@java.com", "253033873"));

        citizens = vaccineDao.insertCitizens(citizens);
        assertEquals(2, citizens.size());
        assertEquals("982553309", vaccineDao.getCitizenByPostalCode("8999").get(0).getTajNumber());
    }

    @Test
    void insertCitizensWithSameTajNumber() {
        List<Citizen> citizens = List.of(new Citizen("John Doe", "8999", 43, "john.doe@java.com", "982553309"),
                new Citizen("Jane Doe", "2000", 33, "jane.doe@java.com", "253033873"));

        citizens = vaccineDao.insertCitizens(citizens);
        assertEquals(2, citizens.size());
        assertEquals("982553309", vaccineDao.getCitizenByPostalCode("8999").get(0).getTajNumber());

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> vaccineDao.insertCitizens(
                        List.of(new Citizen("Jane Doe", "2000", 33, "jane.doe@java.com", "253033873"))));
    }

    @Test
    void readPostalCodesFromDatabase() {

        Map<String, List<PostalCode>> result = vaccineDao.readPostalCodesFromDatabase();
        assertEquals(2, result.get("8999").size());

    }

    @Test
    void reportByPostalCodes() {
        List<Citizen> citizens = List.of(new Citizen("John Doe", "8999", 43, "john.doe@java.com", "982553309"),
                new Citizen("Jane Doe", "2000", 33, "jane.doe@java.com", "253033873"),
                new Citizen("Jack Doe", "2000", 33, "jane.doe@java.com", "987938978"),
                new Citizen("Joe Doe", "2000", 33, "jane.doe@java.com", "916357461"),
                new Citizen("Jill Doe", "2000", 33, "jane.doe@java.com", "745587394")
        );
        citizens = vaccineDao.insertCitizens(citizens);
        assertEquals(5, citizens.size());
        assertEquals(2, vaccineDao.reportByPostalCodes().size());


    }
}