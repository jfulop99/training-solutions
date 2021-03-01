package vaccine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class VaccineValidatorTest {


    VaccineValidator vaccineValidator;

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


        vaccineValidator = new VaccineValidator(new VaccineDao(dataSource).readPostalCodesFromDatabase());


    }

    @Test
    void isValidTajNumber() {
        assertTrue(vaccineValidator.isValidTajNumber("859840602"));
        assertFalse(vaccineValidator.isValidTajNumber("859840601"));
        assertFalse(vaccineValidator.isValidTajNumber("85984060211"));
        assertFalse(vaccineValidator.isValidTajNumber(null));
    }

    @Test
    void isValidEmail() {
        assertTrue(vaccineValidator.isValidEmail("John.Doe@anywhere.com"));
        assertFalse(vaccineValidator.isValidEmail("John.Doe@anywherecom"));
        assertFalse(vaccineValidator.isValidEmail("John.Doeanywhere.com"));
        assertFalse(vaccineValidator.isValidEmail("John.Doe@any@where.com"));
    }

    @Test
    void isValidAge() {
        assertTrue(vaccineValidator.isValidAge("45"));
        assertFalse(vaccineValidator.isValidAge("10"));
        assertFalse(vaccineValidator.isValidAge("150"));
    }

    @Test
    void getPostalCode() {

        assertEquals(1, vaccineValidator.getPostalCode("2000").size());
        assertEquals(2, vaccineValidator.getPostalCode("8999").size());
        assertEquals(0, vaccineValidator.getPostalCode("5104").size());
        assertEquals(0, vaccineValidator.getPostalCode(null).size());

    }

    @Test
    void isEmpty() {

        assertTrue(vaccineValidator.isEmpty(null));
        assertTrue(vaccineValidator.isEmpty("   "));
        assertFalse(vaccineValidator.isEmpty("John Doe"));

    }
}