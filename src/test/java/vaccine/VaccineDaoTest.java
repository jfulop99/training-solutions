package vaccine;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void insertCitizensWithSameTajNumber() {
        List<Citizen> citizens = List.of(new Citizen("John Doe", "8999", 43, "john.doe@java.com", "982553309"),
                new Citizen("Jane Doe", "2000", 33, "jane.doe@java.com", "253033873"));

        citizens = vaccineDao.insertCitizens(citizens);
        assertEquals(2, citizens.size());

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
        assertEquals(30, vaccineDao.reportByPostalCodes().size());


    }

    @Test
    void isTajExist() {
        assertTrue(vaccineDao.isTajExist("336883645"));
        assertFalse(vaccineDao.isTajExist("333333333"));
    }

    @Test
    void getCitizensForVaccination() {

        assertEquals(393, vaccineDao.getCitizensForVaccination(LocalDateTime.of(2021, 03, 02, 8, 0)).size());

    }

    @Test
    void getCitizenByTaj() {

        assertEquals(1000, vaccineDao.getCitizenByTaj("618871089").getId());

    }

    @Test
    void getVaccinationByCitizenId() {

        assertEquals(2, vaccineDao.getVaccinationByCitizenId(1000).size());
        assertEquals(VaccineType.SINOPHARM, vaccineDao.getVaccinationByCitizenId(1000).get(0).getVaccineType());

    }

    @Test
    void insertVaccination() {
        Vaccination vaccination = new Vaccination(999, LocalDateTime.now(), VaccinationStatus.FIRST_VACCINATION, "Insert vaccination test", VaccineType.PFIZER_BIONTECH);

        vaccineDao.insertVaccination(vaccination);
        List<Vaccination> result = vaccineDao.getVaccinationByCitizenId(999);
        assertEquals(VaccinationStatus.FIRST_VACCINATION, result.get(0).getStatus());

    }
}